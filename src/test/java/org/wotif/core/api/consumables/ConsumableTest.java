package org.wotif.core.api.consumables;

import com.google.common.collect.ImmutableList;
import io.vavr.control.Option;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.wotif.core.api.Consumable;
import org.wotif.core.api.objects.TestClass;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.wotif.core.api.Conditions.when;
import static org.wotif.core.api.Conditions.whenAllOf;

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

//
//    @Test
//    public void testMapCase() {
//        List<Integer> resultList_1 = whenAnyOf("test_1", "test_2", "test_3").contains("_")
//                .map(l -> l.stream().map(e -> e.substring(e.lastIndexOf("_") + 1))
//                        .map(Integer::valueOf).collect(Collectors.toList())).end();
//        List<String> resultList_2 = whenAnyOf("test", "test", "test").contains("_")
//                .map(l -> l.stream().map(e -> e.substring(e.lastIndexOf("_") + 1))
//                        .collect(Collectors.toList()))
//                .orElse(ArrayList::new).end();
//
//        Assertions.assertThat(resultList_1).contains(1, 2, 3);
//        Assertions.assertThat(resultList_2).containsExactly("test", "test", "test");
//    }

}
