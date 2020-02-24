/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import io.vavr.control.Either;

import java.util.function.Supplier;

public class Instructions<T, R> {

    private final Result<?> result;

    private Either<Supplier<R>, CallBack> action;

    public Instructions(Result<?> result, Supplier<R> supplier) {
        this.result = result;
        this.action = Either.left(supplier);
    }

    public Instructions(Result<?> result, CallBack callback) {
        this.result = result;
        this.action = Either.right(callback);
    }

    public Result<?> result() {
        return this.result;
    }

    public R executeAction() {
        if (this.action.isLeft()) {
            return this.action.left().get().get();
        }
        this.action.right().get().execute();
        return null;
    }

}
