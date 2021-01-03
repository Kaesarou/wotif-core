/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Completable<T> implements Result<T> {

    Result<T> result;

    public Completable(Term<T> term, boolean value) {
        this.result = Result.of(term, value);
    }

    public <R> Completable<?> and(Supplier<Result<R>> resultSupplier) {
        if (!this.result()) {
            return this;
        }
        boolean squashedResult = Stream.of(resultSupplier.get().result(), this.result()).allMatch(r -> r);
        return new Completable<>(this.result.terms().concat(resultSupplier.get().terms()), squashedResult);
    }

    public <R> Completable<?> or(Supplier<Result<R>> resultSupplier) {
        if (this.result()) {
            return this;
        }
        boolean squashedResult = Stream.of(resultSupplier.get().result(), this.result()).anyMatch(r -> r);
        return new Completable<>(this.result.terms().concat(resultSupplier.get().terms()), squashedResult);
    }

    @Override
    public Term<T> terms() {
        return result.terms();
    }

    @Override
    public T get() {
        return result.get();
    }

    @Override
    public boolean result() {
        return result.result();
    }
}
