package org.wotif.core.api.characters;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.when;

public class CharacterConditionTest {

    @Test
    public void testIfCharacterIsUpperCaseThenReturn1() {
        Integer result = when('C').isUpperCase().then(t ->1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfCharacterIsUpperCaseOrLowerCaseThenReturn2() {
        Integer result = when('c').isUpperCase()
                .then(t ->1).orElse(when('c').isLowerCase(), t ->2)
                .end();
        Assertions.assertThat(result).isEqualTo(2);
    }

}
