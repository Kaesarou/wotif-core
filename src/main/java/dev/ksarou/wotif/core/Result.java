/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Class Result ...
 *
 * @author Cesare de Padua
 * Created on 24/02/2020
 */
public interface Result<T> extends Consumable<T> {

    Term<T> terms();

    static <T> Result<T> of(Term<T> terms, boolean value) {
        return value ? trueInstance(terms) : falseInstance(terms);
    }

    private static <T> Result<T> falseInstance(Term<T> terms) {
        return new Result.False<>(terms);
    }

    private static <T> Result<T> trueInstance(Term<T> terms) {
        return new Result.True<>(terms);
    }

    default InstructionsBlock<T, Void> then(CallBack callback) {
        Objects.requireNonNull(callback, "callback is null");
        Instructions<T, Void> instructions = new Instructions<>(this, callback);
        return new InstructionsBlock<>(instructions);
    }

    default <R> InstructionsBlock<T, R> then(Supplier<R> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        Instructions<T, R> instructions = new Instructions<>(this, supplier);
        return new InstructionsBlock<>(instructions);
    }

    final class False<T> implements Result<T> {

        private final Term<T> terms;

        public False(Term<T> terms) {
            this.terms = terms;
        }

        @Override
        public T get() {
            throw new NoSuchElementException("No value present");
        }

        @Override
        public Term<T> terms() {
            return this.terms;
        }

        @Override
        public boolean result() {
            return false;
        }

    }

    final class True<T> implements Result<T> {

        private final Term<T> terms;

        public True(Term<T> terms) {
            this.terms = terms;
        }

        @Override
        public T get() {
            return this.terms.value();
        }

        @Override
        public Term<T> terms() {
            return this.terms;
        }

        @Override
        public boolean result() {
            return true;
        }

    }

}
