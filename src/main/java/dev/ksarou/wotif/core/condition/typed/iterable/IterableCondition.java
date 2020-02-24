/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable;

public class IterableCondition<T> extends AbstractIterableCondition<T, Iterable<T>>
        implements IIterableCondition<T, Iterable<T>, Iterable<T>> {

    public IterableCondition(Iterable<T> term) {
        super(term);
    }

    @Override
    protected Iterable<T> iterable() {
        return this.term.value();
    }

}
