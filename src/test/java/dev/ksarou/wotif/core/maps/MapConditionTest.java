/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.maps;

import com.google.common.collect.ImmutableMap;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static dev.ksarou.wotif.core.Conditions.*;

public class MapConditionTest {

    @Test
    public void testIfMapContains() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map.Entry<String, String> e1 = Map.entry("a", "1");
        Map.Entry<String, String> e2 = Map.entry("b", "2");

        Integer result = when(mapToTest).contains(e1, e2).then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfAllMapsContains() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> mapToTest_2 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> mapToTest_3 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map.Entry<String, String> e1 = Map.entry("a", "1");
        Map.Entry<String, String> e2 = Map.entry("b", "2");

        Integer result_1 = whenAllOf(mapToTest_1, mapToTest_2, mapToTest_3).contains(e1, e2).then(() -> 1).end();

        Assertions.assertThat(result_1).isEqualTo(1);
    }

    @Test
    public void testIfAnyMapsContains() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> mapToTest_2 = ImmutableMap.<String, String>builder()
                .put("e", "1").put("f", "2").put("j", "3").put("h", "4").put("i", "5")
                .build();
        Map<String, String> mapToTest_3 = ImmutableMap.<String, String>builder()
                .put("j", "1").put("k", "2").put("l", "3").put("m", "4").put("n", "5")
                .build();
        Map.Entry<String, String> e1 = Map.entry("a", "1");
        Map.Entry<String, String> e2 = Map.entry("b", "2");
        Map.Entry<String, String> e3 = Map.entry("j", "3");
        Map.Entry<String, String> e4 = Map.entry("b", "2");

        Integer result_1 = whenAnyOf(mapToTest_1, mapToTest_2, mapToTest_3).contains(e1, e2).then(() -> 1).end();
        Integer result_2 = whenAnyOf(mapToTest_1, mapToTest_2, mapToTest_3).contains(e3, e4).then(() -> 1)
                .orElse(() -> 0).end();
        Integer result_3 = whenAnyOf(mapToTest_1, mapToTest_2, mapToTest_3).contains(e3).then(() -> 1).end();

        Assertions.assertThat(result_1).isEqualTo(1);
        Assertions.assertThat(result_2).isEqualTo(0);
        Assertions.assertThat(result_3).isEqualTo(1);
    }

    @Test
    public void testIfMapDoesNotContains() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map.Entry<String, String> e1 = Map.entry("a", "1");
        Map.Entry<String, String> e2 = Map.entry("g", "2");

        Integer result = when(mapToTest).contains(e1)
                .and(() -> when(mapToTest).doesNotContains(e2))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsKeysAndDoesNotContainsKeys() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        String k_1 = "a";
        String k_2 = "c";
        String k_3 = "f";

        Integer result = when(mapToTest).containsKeys(k_1, k_2)
                .and(() -> when(mapToTest).doesNotContainsKeys(k_3))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsValuesAndDoesNotContainsValues() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        String k_1 = "1";
        String k_2 = "2";
        String k_3 = "6";

        Integer result = when(mapToTest).containsValues(k_1, k_2)
                .and(() -> when(mapToTest).doesNotContainsValues(k_3))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsAllEntriesOfAndDoesNotContainsAllEntriesOf() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> m_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4")
                .build();
        Map<String, String> m_2 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5").put("f", "6")
                .build();

        Integer result = when(mapToTest).containsAllEntriesOf(m_1)
                .and(() -> when(mapToTest).doesNotContainsAllEntriesOf(m_2))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsAnyOf() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map.Entry<String, String> e1 = Map.entry("a", "1");
        Map.Entry<String, String> e2 = Map.entry("o", "2");
        Map.Entry<String, String> e3 = Map.entry("f", "1");

        Integer result = when(mapToTest).containsAnyOf(e1, e2)
                .and(() -> when(mapToTest).doesNotContainsAnyOf(e2, e3)).then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsAnyEntriesOfAndDoesNotContainsAnyEntriesOf() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> m_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("c", "2").put("d", "3").put("e", "4")
                .build();
        Map<String, String> m_2 = ImmutableMap.<String, String>builder()
                .put("f", "1").put("k", "2").put("g", "3").put("h", "4").put("i", "5").put("j", "6")
                .build();

        Integer result = when(mapToTest).containsAnyEntriesOf(m_1)
                .and(() -> when(mapToTest).containsNoneEntriesOf(m_2))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsOnlyAndDoesNotContainsOnly() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4")
                .build();
        Map.Entry<String, String> e_1 = Map.entry("a", "1");
        Map.Entry<String, String> e_2 = Map.entry("b", "2");
        Map.Entry<String, String> e_3 = Map.entry("c", "3");
        Map.Entry<String, String> e_4 = Map.entry("d", "4");

        Integer result = when(mapToTest).containsOnly(e_1, e_2, e_3, e_4)
                .and(() -> when(mapToTest).doesNotContainsOnly(e_1, e_2, e_3))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsOnlyEntriesOfAndDoesNotContainsOnlyEntriesOf() {
        Map<String, String> mapToTest = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> m_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> m_2 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3")
                .build();

        Integer result = when(mapToTest).containsOnlyEntriesOf(m_1)
                .and(() -> when(mapToTest).doesNotContainsOnlyEntriesOf(m_2))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsOnlyOnceValuesAndContainsMoreThanOnceValues() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();
        Map<String, String> mapToTest_2 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "2").put("d", "4").put("e", "5")
                .build();

        Integer result = when(mapToTest_1).containsOnlyOnceValues("1", "2", "3", "4", "5")
                .and(() -> when(mapToTest_2).containsMoreThanOnceValues("2"))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapIsEmptyAndIsNotEmpty() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder().build();
        Map<String, String> mapToTest_2 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "2").put("d", "4").put("e", "5")
                .build();

        Integer result = when(mapToTest_1).isEmpty()
                .and(() -> when(mapToTest_2).isNotEmpty())
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapHasAnyValuesOfTypesAndDoesNotHasAnyValuesOfTypes() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();

        Integer result_1 = when(mapToTest_1).hasAnyValuesOfTypes(String.class)
                .and(() -> when(mapToTest_1).doesNotHasAnyValuesOfTypes(Integer.class))
                .then(() -> 1).end();
        Integer result_2 = when(mapToTest_1).hasAnyValuesOfTypes(Integer.class)
                .and(() -> when(mapToTest_1).doesNotHasAnyValuesOfTypes(String.class))
                .then(() -> 1).orElse(() -> 0).end();

        Assertions.assertThat(result_1).isEqualTo(1);
        Assertions.assertThat(result_2).isEqualTo(0);
    }

    @Test
    public void testIfContainsNullValuesAndDoesNotContainsNullValues() {
        Map<String, String> mapToTest_1 = new HashMap<>();
        mapToTest_1.put("a", "1");
        mapToTest_1.put("b", null);
        mapToTest_1.put("c", "3");
        mapToTest_1.put("d", "4");
        mapToTest_1.put("e", "5");
        Map<String, String> mapToTest_2 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "2").put("d", "4").put("e", "5")
                .build();

        Integer result = when(mapToTest_1).containsNullValues()
                .and(() -> when(mapToTest_2).doesNotContainsNullValues())
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfContainsOnlyNullValuesAndDoesNotContainsOnlyNullValues() {
        Map<String, String> mapToTest_1 = new HashMap<>();
        mapToTest_1.put("a", null);
        mapToTest_1.put("b", null);
        Map<String, String> mapToTest_2 = new HashMap<>();
        mapToTest_2.put("a", "1");
        mapToTest_2.put("b", null);

        Integer result = when(mapToTest_1).containsOnlyNullValues()
                .and(() -> when(mapToTest_2).doesNotContainsOnlyNullValues())
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapContainsDuplicateValuesAndDoesNotContainsDuplicateValues() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "2").put("d", "4").put("e", "5")
                .build();
        Map<String, String> mapToTest_2 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "3").put("d", "4").put("e", "5")
                .build();

        Integer result = when(mapToTest_1).hasDuplicateValues()
                .and(() -> when(mapToTest_2).doesNotHasDuplicateValues())
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapAnyValuesMatch() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "2").put("d", "4").put("e", "5")
                .build();

        Integer result = when(mapToTest_1).anyValuesMatch(v -> v.equals("2"))
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapAllValuesMatch() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "2").put("d", "4").put("e", "5")
                .build();

        Integer result = when(mapToTest_1).allValuesMatch(v -> !v.isBlank())
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfMapNoneValuesMatch() {
        Map<String, String> mapToTest_1 = ImmutableMap.<String, String>builder()
                .put("a", "1").put("b", "2").put("c", "2").put("d", "4").put("e", "5")
                .build();

        Integer result = when(mapToTest_1).noneValuesMatch(String::isBlank)
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

}
