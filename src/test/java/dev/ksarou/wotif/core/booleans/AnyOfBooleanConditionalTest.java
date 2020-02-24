/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.booleans;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static dev.ksarou.wotif.core.Conditions.whenAnyOf;

public class AnyOfBooleanConditionalTest {

    @Test
    public void ifAnyOfThisBooleansIsTrueReturnOne() {
        Integer result = whenAnyOf(false, true, false, false).isTrue().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifAnyOfThisBooleansIsTrueReturnOneExpectedZero() {
        Integer result = whenAnyOf(false, false, false, false).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void orElseReturnZeroWithoutExecutionsExpectedOne() {
        Integer result = whenAnyOf(false, false, true, false).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOne() {
        Integer result = whenAnyOf(true, true, false).isFalse()
                .then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOneElseZeroExpectedOne() {
        Integer result = whenAnyOf(true, true, false).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnOne() {
        Integer result = whenAnyOf(false, false, true).isEqualTo(true)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnZero() {
        Integer result = whenAnyOf(true, true, true).isEqualTo(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifVariableIsNotEqualToTrueThenReturnZero() {
        Integer result = whenAnyOf(false, false, true).isDifferentFrom(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNullThenReturnOne() {
        Integer result = whenAnyOf(null, false, false).isNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNotNullThenReturnOne() {
        Integer result = whenAnyOf(null, null, true).isNotNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

}
