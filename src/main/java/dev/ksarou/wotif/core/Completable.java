/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import com.google.common.collect.ImmutableList;

import java.util.stream.Stream;

public class Completable<T> extends Result<T> {

    public Completable(Term<T> term, boolean value) {
        super(term, value);
    }

    public <R> Completable<?> and(Result<R> result) {
        boolean squashedResult = Stream.of(result.result(), this.result()).allMatch(r -> r);
        return new Completable<>(new Term<>(ImmutableList.of(result.terms(), this.terms())), squashedResult);
    }

    public <R> Completable<?> or(Result<R> result) {
        boolean squashedResult = Stream.of(result.result(), this.result()).anyMatch(r -> r);
        return new Completable<>(new Term<>(ImmutableList.of(result.result())), squashedResult);
    }

}
