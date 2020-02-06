package org.wotif.core.api.character;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.wotif.core.api.Conditions.checkIf;

public class CharacterConditionTest {

    @Test
    public void testIfCharacterIsUpperCaseThenReturn1() {
        Integer result = checkIf('C').isUpperCase().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfCharacterIsUpperCaseOrLowerCaseThenReturn2() {
        Integer result = checkIf('c').isUpperCase()
                .then(() -> 1).orElse(checkIf('c').isLowerCase(), () -> 2)
                .end();
        Assertions.assertThat(result).isEqualTo(2);
    }

}
