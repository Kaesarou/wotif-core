package dev.ksarou.wotif.core.consumables;

import com.google.common.collect.ImmutableList;
import dev.ksarou.wotif.core.Consumable;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import dev.ksarou.wotif.core.objects.TestClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static dev.ksarou.wotif.core.Conditions.when;
import static dev.ksarou.wotif.core.Conditions.whenAllOf;

public class ConsumableTest {

    @Test
    public void testIfContainsPropertyThenMap() {
        TestClass objectToTest_1 = new TestClass("test", 1, true);

        String result = when(objectToTest_1).hasProperty("property_1").map(TestClass::getProperty_1).get();
        List<Integer> list = whenAllOf(1, 2, 3).isPositive().map(l ->
                l.stream().map(e -> e * -1).collect(Collectors.toList())
        ).get();

        Assertions.assertThat(result).isEqualTo("test");
        Assertions.assertThat(list).contains(-1, -2, -3);
    }

    @Test
    public void testFlatMap() {
        List<List<Integer>> listsToTest = ImmutableList.<List<Integer>>builder()
                .add(ImmutableList.of(1))
                .add(ImmutableList.of(1))
                .add(ImmutableList.of(1))
                .build();

        Iterable<List<Integer>> lists = when(listsToTest).hasAnyElementsOfTypes(List.class)
                .flatMap(Consumable::of)
                .get();

        Assertions.assertThat(lists).isEqualTo(listsToTest);
    }

    @Test
    public void testFilter() {
        TestClass objectToTest_1 = new TestClass("test", 1, true);

        String result = when(objectToTest_1).hasProperty("property_1")
                .map(TestClass::getProperty_1).filter(t -> t.equals("test"))
                .get();

        Assertions.assertThat(result).isEqualTo("test");

    }

    @Test
    public void testFilterThenGetOrNull() {
        TestClass objectToTest_1 = new TestClass("test", 1, true);

        String result = when(objectToTest_1).hasProperty("property_1")
                .map(TestClass::getProperty_1).filter(t -> t.equals("TEST"))
                .getOrNull();

        Assertions.assertThat(result).isNull();
    }

    @Test
    public void testFilterThenGetOrElse() {
        TestClass objectToTest_1 = new TestClass("test", 1, true);

        String result = when(objectToTest_1).hasProperty("property_1")
                .map(TestClass::getProperty_1).filter(t -> t.equals("TEST"))
                .getOrElse("TEST");

        Assertions.assertThat(result).isEqualTo("TEST");
    }

    @Test
    public void testMapAfterAFilterReturningNull() {
        List<Integer> objectToTest_1 = ImmutableList.of(1, -2, 3, -4);

        List<Integer> result = when(objectToTest_1).hasAnyElementsOfTypes(Integer.class)
                .map(e -> StreamSupport.stream(e.spliterator(), false))
                .map(s -> s.filter(e -> e >= 0))
                .filter(s -> s.anyMatch(e -> e < 0))
                .map(e -> e.collect(Collectors.toList()))
                .getOrElse(new ArrayList<>());

        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void testMapThenPeek() {
        List<Integer> objectToTest_1 = ImmutableList.of(1, -2, 3, -4);

        List<Integer> result = when(objectToTest_1).anyMatch(e -> e < 0)
                .map(e -> StreamSupport.stream(e.spliterator(), false))
                .map(d -> d.map(e -> e < 0 ? e * -1 : e))
                .map(f -> f.collect(Collectors.toList()))
                .peek(f -> f.add(5)).getOrNull();

        Assertions.assertThat(result).contains(5);
        Assertions.assertThat(result).allMatch(e -> e >= 0);

    }

}
