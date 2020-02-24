/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IntArraysCondition extends AbstractIterableCondition<Integer, int[]>
        implements IIterableCondition<Integer, int[], int[]> {

    public IntArraysCondition(int[] term) {
        super(term);
    }

    @Override
    protected Iterable<Integer> iterable() {
        return Arrays.stream(this.term.value()).boxed().collect(Collectors.toList());
    }

}
