/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import io.vavr.control.Either;

import java.util.Optional;
import java.util.function.Supplier;

public class Instructions<R> {

    private final Either<Supplier<R>, Runnable> action;

    public Instructions(Supplier<R> supplier) {
        this.action = Either.left(supplier);
    }

    public Instructions(Runnable callback) {
        this.action = Either.right(callback);
    }

    public R executeAction() {
        return this.action.fold(Supplier::get, runnable -> {
            runnable.run();
            return null;
        });
    }

}
