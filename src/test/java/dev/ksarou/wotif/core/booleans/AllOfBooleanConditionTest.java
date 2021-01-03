/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.booleans;

import dev.ksarou.wotif.core.Conditions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllOfBooleanConditionTest {

    @Test
    public void testAllOfWithIsTrueThenReturnOne() {
        Integer result = Conditions.whenAllOf(true, true, true).isTrue()
                .then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithIsTrueThenReturnZero() {
        Integer result = Conditions.whenAllOf(true, true, false).isTrue()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithIsFalseThenReturnOne() {
        Integer result = Conditions.whenAllOf(false, false, false).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithIsFalseThenReturnZero() {
        Integer result = Conditions.whenAllOf(true, false, false).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
