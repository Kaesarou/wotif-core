package org.wotif.core.api;

import io.vavr.PartialFunction;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Consumable<T> {

    T get();

    boolean result();

    static <T> Consumable<T> of(T value) {
        return value == null ? none() : some(value);
    }

    static <T> Consumable<T> some(T value) {
        return new Consumable.Some<>(value);
    }

    static <T> Consumable<T> none() {
        return new Consumable.None<>();
    }

    default <R> Consumable<R> map(Function<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return result() ? none() : some(mapper.apply(get()));
    }

    default Consumable<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return !this.result() && !predicate.test(this.get()) ? none() : this;
    }

    default <U> Consumable<U> flatMap(Function<? super T, ? extends Consumable<? extends U>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return this.result() ? none() : (Consumable<U>) mapper.apply(this.get());
    }

    default <R> Consumable<R> collect(PartialFunction<? super T, ? extends R> partialFunction) {
        Objects.requireNonNull(partialFunction, "partialFunction is null");
        Consumable<T> filtered = this.filter(partialFunction::isDefinedAt);
        return filtered.map(partialFunction::apply);
    }

    default Consumable<T> peek(Consumer<? super T> action) {
        Objects.requireNonNull(action, "action is null");
        if (this.result()) {
            action.accept(this.get());
        }
        return this;
    }

    final class None<T> implements Consumable<T> {

        public T get() {
            throw new NoSuchElementException("No value present");
        }

        @Override
        public boolean result() {
            return true;
        }

    }

    final class Some<T> implements Consumable<T>, Serializable {

        private final T value;

        private Some(T value) {
            this.value = value;
        }

        public T get() {
            return this.value;
        }

        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean result() {
            return false;
        }
    }

}
