/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import java.util.Objects;
import java.util.function.Supplier;

public class Result<T> implements Consumable<T> {

    private final Term<T> terms;

    private final boolean result;

    public boolean result() {
        return this.result;
    }

    public Term<T> terms() {
        return this.terms;
    }

    @Override
    public T get() {
        return this.terms.value();
    }

    public Result(Term<T> terms, boolean result) {
        this.terms = terms;
        this.result = result;
    }

    public InstructionsBlock<T, Void> then(CallBack callback) {
        Objects.requireNonNull(callback, "callback is null");
        Instructions<T, Void> instructions = new Instructions<>(this, callback);
        return new InstructionsBlock<>(instructions);
    }

    public <R> InstructionsBlock<T, R> then(Supplier<R> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        Instructions<T, R> instructions = new Instructions<>(this, supplier);
        return new InstructionsBlock<>(instructions);
    }

}
