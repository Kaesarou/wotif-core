/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.AbstractCondition;

public abstract class ComparableCondition<T extends Comparable<T>>
        extends AbstractCondition<T> implements IComparableCondition<T, T> {

    public ComparableCondition(T term) {
        super(term);
    }

    @Override
    public Completable<T> isLessThen(T termToCompare) {
        int i = term.value().compareTo(termToCompare);
        return new Completable<>(term, i < 0);
    }

    @Override
    public Completable<T> isGreaterThen(T termToCompare) {
        int i = term.value().compareTo(termToCompare);
        return new Completable<>(term, i > 0);
    }

    @Override
    public Completable<T> isEqualTo(T expected) {
        int i = term.value().compareTo(expected);
        return new Completable<>(term, i == 0);
    }

    @Override
    public Completable<T> isDifferentFrom(T expected) {
        int i = term.value().compareTo(expected);
        return new Completable<>(term, i != 0);
    }

    @Override
    public Completable<T> isBetween(T start, T end) {
        int i = term.value().compareTo(start);
        int j = term.value().compareTo(end);
        return new Completable<>(term, i >= 0 && j <= 0);
    }

    @Override
    public Completable<T> isNotBetween(T start, T end) {
        int i = term.value().compareTo(start);
        int j = term.value().compareTo(end);
        return new Completable<>(term, i < 0 || j > 0);
    }

    @Override
    public Completable<T> isStrictlyBetween(T start, T end) {
        int i = term.value().compareTo(start);
        int j = term.value().compareTo(end);
        return new Completable<>(term, i > 0 && j < 0);
    }

}
