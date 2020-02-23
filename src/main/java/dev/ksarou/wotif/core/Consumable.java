package dev.ksarou.wotif.core;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Consumable<T> {

    T get();

    boolean result();

    static <T> Consumable<T> of(T value) {
        return value == null ? none() : some(value);
    }

    private static <T> Consumable<T> some(T value) {
        return new Consumable.Some<>(value);
    }

    private static <T> Consumable<T> none() {
        Consumable.None<T> none = (None<T>) None.INSTANCE;
        return none;
    }

    default <R> Consumable<R> map(Function<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return result() ? some(mapper.apply(get())) : none();
    }

    default Consumable<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return this.result() && !predicate.test(this.get()) ? none() : this;
    }

    default <U> Consumable<U> flatMap(Function<? super T, ? extends Consumable<? extends U>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return this.result() ? (Consumable<U>) mapper.apply(this.get()) : none();
    }

    default Consumable<T> peek(Consumer<? super T> action) {
        Objects.requireNonNull(action, "action is null");
        if (this.result()) {
            action.accept(this.get());
        }
        return this;
    }

    default T getOrElse(T other) {
        return this.result() ? this.get() : other;
    }

    default T getOrElse(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return this.result() ? this.get() : supplier.get();
    }

    default T getOrNull() {
        return this.result() ? this.get() : null;
    }

    final class None<T> implements Consumable<T> {

        private static final None<?> INSTANCE = new None<>();

        public T get() {
            throw new NoSuchElementException("No value present");
        }

        @Override
        public boolean result() {
            return false;
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

        @Override
        public boolean result() {
            return true;
        }
    }

}
