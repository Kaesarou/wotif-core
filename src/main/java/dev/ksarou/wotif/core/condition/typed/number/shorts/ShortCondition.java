/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.shorts;

import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberCondition;

public class ShortCondition extends AbstractNumberCondition<Short> {

    public ShortCondition(Short term) {
        super(term);
    }

    @Override
    protected Short zero() {
        return 0;
    }

}
