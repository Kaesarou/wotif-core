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
 * Class Result contains the result of a statement
 * and the terms used for the evaluation
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

    /**
     * Method then : instructions to execute if the value of
     * the result is true
     *
     * @param callback of type CallBack, contains an expression with no arguments
     *                 and no return value
     * @return InstructionsBlock<T, Void>
     */
    default InstructionsBlock<Void> then(Runnable callback) {
        Objects.requireNonNull(callback, "callback is null");
        Instructions<Void> instructions = new Instructions<>(callback);
        return new InstructionsBlock<>(this, instructions);
    }

    /**
     * Method then : instructions to execute if the value of
     * the result is true
     *
     * @param supplier of type Supplier<R>
     * @return InstructionsBlock<T, R>
     */
    default <R> InstructionsBlock<R> then(Supplier<R> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        Instructions<R> instructions = new Instructions<>(supplier);
        return new InstructionsBlock<>(this, instructions);
    }

    /**
     * Class False
     * a result with false value
     *
     * @author Cesare de Padua
     * Created on 26/02/2020
     */
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

    /**
     * Class True
     * a result with true value
     *
     * @author Cesare de Padua
     * Created on 26/02/2020
     */
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
