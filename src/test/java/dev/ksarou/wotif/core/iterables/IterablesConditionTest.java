package dev.ksarou.wotif.core.iterables;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static dev.ksarou.wotif.core.Conditions.when;
import static dev.ksarou.wotif.core.Conditions.whenAnyOf;

public class IterablesConditionTest {

    @Test
    public void testIfArrayContainsThenReturn1() {
        Character[] arrayToTest = {'a', 'b', 'c'};
        Integer result = when(arrayToTest).contains('c').then(() ->1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfArrayNotContainsThenReturn1() {
        Character[] arrayToTest = {'a', 'b', 'c'};
        Integer result = when(arrayToTest).doesNotContains('d').then(() ->1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfContainsAnyOf() {
        Integer[] arrayToTest = {1, 2, 3, 4};
        Integer result1 = when(arrayToTest).containsAnyOf(2, 3).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).containsAnyOf(1, 6, 9).then(() ->1).end();
        Assertions.assertThat(result2).isEqualTo(1);
        Integer result3 = when(arrayToTest).containsAnyOf(Arrays.asList(5, 6, 7)).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result3).isEqualTo(0);
    }

    @Test
    public void testIfContainsOnly() {
        Integer[] arrayToTest = {1, 2, 3, 4};
        Integer result1 = when(arrayToTest).containsOnly(1, 2, 3, 4).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).containsOnly(1, 2, 3)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfNotContainsOnly() {
        Integer[] arrayToTest = {1, 2, 3, 4};
        Integer result1 = when(arrayToTest).doesNotContainsOnly(1, 2, 3).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).doesNotContainsOnly(1, 2, 3, 4)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfContainsOnlyOnce() {
        Integer[] arrayToTest = {1, 2, 3, 4, 4};
        Integer result1 = when(arrayToTest).containsOnlyOnce(1, 2, 3).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).containsOnlyOnce(1, 2, 3, 4)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
        Integer result3 = when(arrayToTest).containsOnlyOnce(1, 2, 5)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result3).isEqualTo(0);
        Integer result4 = when(arrayToTest).containsOnlyOnce(1)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result4).isEqualTo(1);
        Integer result5 = when(arrayToTest).containsOnlyOnce(4)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result5).isEqualTo(0);
    }

    @Test
    public void testIfContainsMoreThanOnce() {
        Integer[] arrayToTest = {1, 2, 3, 4, 4};
        Integer result1 = when(arrayToTest).containsMoreThanOnce(4).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).containsMoreThanOnce(1, 2, 3, 4)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
        Integer result3 = when(arrayToTest).containsMoreThanOnce(1, 2, 5)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result3).isEqualTo(0);
        Integer result4 = when(arrayToTest).containsMoreThanOnce(5)
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result4).isEqualTo(0);
    }

    @Test
    public void testIfStartWith() {
        Integer[] arrayToTest = {1, 2, 3, 4, 4};
        Integer result1 = when(arrayToTest).startsWith(1).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).startsWith(2).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfEndWith() {
        Integer[] arrayToTest = {1, 2, 3, 4};
        Integer result1 = when(arrayToTest).endsWith(4).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).endsWith(2).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfIsSubset() {
        Integer[] arrayToTest = {1, 2, 3, 4, 5};
        Integer result1 = when(arrayToTest).isSubsetOf(1, 2, 3, 4, 5, 6).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer result2 = when(arrayToTest).isSubsetOf(1, 2, 3, 4).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfIsEmpty() {
        Integer[] arrayToTest1 = {};
        Integer result1 = when(arrayToTest1).isEmpty().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, 2, 3, 4, 5};
        Integer result2 = when(arrayToTest2).isEmpty().then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfHasAnyElementsOfTypes() {
        Integer[] arrayToTest1 = {1, 2, 3, 4, 5};
        Integer result1 = when(arrayToTest1).hasAnyElementsOfTypes(Integer.class, Character.class)
                .then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, 2, 3, 4, 5};
        Integer result2 = when(arrayToTest2).hasAnyElementsOfTypes(Character.class).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfDoesNotHasAnyElementsOfTypes() {
        Integer[] arrayToTest1 = {1, 2, 3, 4, 5};
        Integer result1 = when(arrayToTest1).doesNotHasAnyElementsOfTypes(Character.class)
                .then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, 2, 3, 4, 5};
        Integer result2 = when(arrayToTest2).doesNotHasAnyElementsOfTypes(Character.class, Integer.class).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfContainsNull() {
        Integer[] arrayToTest1 = {1, 2, 3, 4, null};
        Integer result1 = when(arrayToTest1).containsNull().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, 2, 3, 4, 5};
        Integer result2 = when(arrayToTest2).containsNull().then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfDoesNotContainsNull() {
        Integer[] arrayToTest1 = {1, 2, 3, 4};
        Integer result1 = when(arrayToTest1).doesNotContainsNull().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, 2, 3, 4, null};
        Integer result2 = when(arrayToTest2).doesNotContainsNull().then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfContainsOnlyNull() {
        Integer[] arrayToTest1 = {null, null, null, null};
        Integer result1 = when(arrayToTest1).containsOnlyNull().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, 2, 3, 4, null};
        Integer result2 = when(arrayToTest2).containsOnlyNull().then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfDoesNotContainsOnlyNull() {
        Integer[] arrayToTest1 = {null, null, null, 1};
        Integer result1 = when(arrayToTest1).doesNotContainsOnlyNull().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {null, null, null, null};
        Integer result2 = when(arrayToTest2).doesNotContainsOnlyNull().then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfContainsDuplicate() {
        Integer[] arrayToTest1 = {1, 1, 2, 1};
        Integer result1 = when(arrayToTest1).hasDuplicate().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, 2, 3, null};
        Integer result2 = when(arrayToTest2).hasDuplicate().then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfNotContainsDuplicate() {
        Integer[] arrayToTest1 = {1, 2, 3, 4};
        Integer result1 = when(arrayToTest1).doesNotHasDuplicate().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest2 = {1, null, 3, null};
        Integer result2 = when(arrayToTest2).doesNotHasDuplicate().then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testHasSameSizeAs() {
        Integer[] arrayToTest1 = {1, 2, 3, 4};
        Integer[] arrayToTest2 = {1, null, 3, null};
        Integer result1 = when(arrayToTest1).hasSameSizeAs(arrayToTest2).then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        Integer[] arrayToTest3 = {1, 2, 3, 4};
        Integer[] arrayToTest4 = {1, null, 3};
        Integer result2 = when(arrayToTest3).hasSameSizeAs(arrayToTest4).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
        Assertions.assertThat(arrayToTest1).contains(1);
    }

    @Test
    public void testIfIntArrayContains() {
        int[] arrayToTest1 = {1, 1, 2, 1};
        Integer result1 = when(arrayToTest1).containsNull().then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(null);
        int[] arrayToTest2 = {1, 2, 3, 4};
        int comparator = 1;
        Integer result2 = when(arrayToTest2).contains(comparator).then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(1);
    }

    @Test
    public void testIfCharArrayContains() {
        char[] arrayToTest1 = {'a', 'b', 'c', 'd'};
        Integer result1 = when(arrayToTest1).contains('a').then(() ->1).end();
        Assertions.assertThat(result1).isEqualTo(1);
        char[] arrayToTest2 = {'a', 'b', 'c', 'd'};
        Integer result2 = when(arrayToTest2).contains('e').then(() ->1)
                .orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIterables() {
        List<Character> listCharacters = ImmutableList.of('a', 'b', 'c', 'd');
        List<Character> listCharacters2 = ImmutableList.of('e', 'f', 'g', 'h');
        Set<String> setStrings = ImmutableSet.of("aa", "bb", "cc", "dd");
        Integer result = whenAnyOf(listCharacters, listCharacters2).contains('c')
                .and(when(setStrings).hasSizeBetween(1, 6))
                .and(when(listCharacters).anyMatch(e -> e.equals('b')))
                .then(() ->1).end();
        Assertions.assertThat(result).isEqualTo(1);
        Integer result2 = whenAnyOf(listCharacters, listCharacters2).contains('j')
                .and(when(setStrings).hasSizeBetween(1, 6))
                .and(when(listCharacters).anyMatch(e -> e.equals('b')))
                .then(() ->1).orElse(() ->0).end();
        Assertions.assertThat(result2).isEqualTo(0);
    }

    @Test
    public void testIfImmutableListsInListAreInstancesOfList() {
        List<List<Integer>> listsToTest = ImmutableList.<List<Integer>>builder()
                .add(ImmutableList.of(1))
                .add(ImmutableList.of(1))
                .add(ImmutableList.of(1))
                .build();

        Integer result = when(listsToTest).hasAnyElementsOfTypes(List.class)
                .then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

}
