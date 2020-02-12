package org.wotif.core.api.objects;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.when;

public class ObjectConditionTest {

    @Test
    public void testIfHasNullPropertiesAndDoesNotHasNullProperties() {
        TestClass objectToTest_1 = new TestClass(null, 1, true);
        TestClass objectToTest_2 = new TestClass("test", 1, true);

        Integer result = when(objectToTest_1).hasNullProperties()
                .and(when(objectToTest_2).doesNotHasNullProperties()).then(() -> 1).end();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfObjectHasAllNullProperties() {
        TestClass objectToTest_1 = new TestClass(null, null, null);
        TestClass objectToTest_2 = new TestClass(null, null, true);

        Integer result_1 = when(objectToTest_1).hasAllNullProperties().then(() -> 1).end();
        Integer result_2 = when(objectToTest_2).hasAllNullProperties().then(() -> 1)
                .orElse(() -> 0).end();

        Assertions.assertThat(result_1).isEqualTo(1);
        Assertions.assertThat(result_2).isEqualTo(0);
    }

    @Test
    public void testIfObjectHasNoNullProperties() {
        TestClass objectToTest_1 = new TestClass("test", 1, true);
        TestClass objectToTest_2 = new TestClass(null, 1, true);

        Integer result_1 = when(objectToTest_1).hasNoNullProperties().then(() -> 1).end();
        Integer result_2 = when(objectToTest_2).hasNoNullProperties().then(() -> 1)
                .orElse(() -> 0).end();

        Assertions.assertThat(result_1).isEqualTo(1);
        Assertions.assertThat(result_2).isEqualTo(0);
    }

    @Test
    public void testIfObjectHasProperty() {
        TestClass objectToTest_1 = new TestClass("test", 1, true);

        Integer result_1 = when(objectToTest_1).hasProperty("property_1")
                .and(when(objectToTest_1).doesNotHasProperty("test")).then(() -> 1).end();

        Assertions.assertThat(result_1).isEqualTo(1);
    }

    @Test
    public void testIfObjectHasPropertyWithValue() {
        TestClass objectToTest_1 = new TestClass("test", 1, true);

        Integer result_1 = when(objectToTest_1).hasPropertyWithValue("property_1", "test")
                .and(when(objectToTest_1).doesNotHasPropertyWithValue("property_2", 2)).then(() -> 1).end();

        Assertions.assertThat(result_1).isEqualTo(1);
    }

}
