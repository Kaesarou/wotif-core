package org.wotif.core.api.controls;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.wotif.core.api.Conditions.whenAnyOf;

public class ControlsTest {

    @Test
    public void testMapCase() {
        List<Integer> resultList_1 = whenAnyOf("test_1", "test_2", "test_3").contains("_")
                .map(l -> l.stream().map(e -> e.substring(e.lastIndexOf("_") + 1))
                        .map(Integer::valueOf).collect(Collectors.toList())).end();
        List<String> resultList_2 = whenAnyOf("test", "test", "test").contains("_")
                .map(l -> l.stream().map(e -> e.substring(e.lastIndexOf("_") + 1))
                        .collect(Collectors.toList()))
                .orElse(ArrayList::new).end();

        Assertions.assertThat(resultList_1).contains(1, 2, 3);
        Assertions.assertThat(resultList_2).containsExactly("test", "test", "test");
    }

}
