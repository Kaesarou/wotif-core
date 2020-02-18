package org.wotif.core.api.controls;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.wotif.core.api.objects.TestClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.wotif.core.api.Conditions.*;

public class ControlsTest {

    @Test
    public void testIfContainsPropertyThenMap() {
//        TestClass objectToTest_1 = new TestClass("test", 1, true);
//
//        when(objectToTest_1).hasProperty("").then(l -> 1).

//        String result = when(objectToTest_1).hasProperty("property_1").map(TestClass::getProperty_1).end();
//        List<Integer> list = whenAllOf(1, 2, 3).isPositive().map(l -> {
//            List<Integer> newList = new ArrayList<>(l);
//            newList.add(4);
//            return newList;
//        });

//        Assertions.assertThat(result).isEqualTo("test");
//        Assertions.assertThat(list).contains(1,2,3,4);
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
