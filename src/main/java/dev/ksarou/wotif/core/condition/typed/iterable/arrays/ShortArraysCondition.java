/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.ArrayList;
import java.util.List;

public class ShortArraysCondition extends AbstractIterableCondition<Short, short[]>
        implements IIterableCondition<Short, short[], short[]> {

    public ShortArraysCondition(short[] term) {
        super(term);
    }

    @Override
    protected Iterable<Short> iterable() {
        List<Short> shorts = new ArrayList<>();
        for (short s : this.term.value()) {
            shorts.add(s);
        }
        return shorts;
    }

}
