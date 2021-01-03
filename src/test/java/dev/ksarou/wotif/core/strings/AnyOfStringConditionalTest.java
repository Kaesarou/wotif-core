/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static dev.ksarou.wotif.core.Conditions.whenAnyOf;

public class AnyOfStringConditionalTest {

    @Test
    public void testAnyOfWithContainsThenReturnOne() {
        Integer result = whenAnyOf("test", "none", "none").contains("est")
                .then(() -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAnyOfWithContainsThenReturnZero() {
        Integer result = whenAnyOf("none", "none", "none").contains("est")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAnyOfWithEqualsThenReturnOne() {
        Integer result = whenAnyOf("test", "none", "none").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAnyOfWithEqualsThenReturnZero() {
        Integer result = whenAnyOf("none", "none", "none").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAnyOfWithIsNullThenReturnOne() {
        Integer result = whenAnyOf(null, "string", "string").isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAnyOfWithIsNullThenReturnZero() {
        Integer result = whenAnyOf("string", "string", "string").isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
