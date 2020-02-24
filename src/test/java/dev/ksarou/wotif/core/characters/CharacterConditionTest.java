/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.characters;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static dev.ksarou.wotif.core.Conditions.when;

public class CharacterConditionTest {

    @Test
    public void testIfCharacterIsUpperCaseThenReturn1() {
        Integer result = when('C').isUpperCase().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfCharacterIsUpperCaseOrLowerCaseThenReturn2() {
        Integer result = when('c').isUpperCase()
                .then(() -> 1).orElse(when('c').isLowerCase(), () -> 2)
                .end();
        Assertions.assertThat(result).isEqualTo(2);
    }

}
