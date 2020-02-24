/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable;

import dev.ksarou.wotif.core.condition.JoinEnum;

import java.util.List;

public class IterableJoinCondition<T>
        extends AbstractIterableJoinCondition<T, Iterable<T>>
        implements IIterableCondition<T, Iterable<T>, List<Iterable<T>>> {

    @SafeVarargs
    public IterableJoinCondition(JoinEnum joinIype, Iterable<T>... terms) {
        super(joinIype, terms);
    }

    @Override
    public IterableCondition<T> getInstanceOfCondition(Iterable<T> term) {
        return new IterableCondition<>(term);
    }

}
