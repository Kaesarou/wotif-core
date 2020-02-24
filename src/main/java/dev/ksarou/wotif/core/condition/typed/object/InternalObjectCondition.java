/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.object;

import dev.ksarou.wotif.core.Term;
import io.vavr.control.Try;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

class InternalObjectCondition<T> {

    Term<T> term;

    InternalObjectCondition(Term<T> term) {
        this.term = term;
    }

    private Stream<Field> fields() {
        Field[] fields = this.term.value().getClass().getDeclaredFields();
        return Arrays.stream(fields).filter(m -> !m.isSynthetic());
    }

    private boolean check(Field f, FieldChecker fieldChecker) throws IllegalAccessException {
        boolean result;
        if (Modifier.isPrivate(f.getModifiers())) {
            f.setAccessible(true);
            result = fieldChecker.check();
            f.setAccessible(false);
        } else {
            result = fieldChecker.check();
        }
        return result;
    }

    private boolean isNull(Field f) {
        return Try.of(() -> check(f, () -> f.get(this.term.value()) == null))
                .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);
    }

    private boolean propertyNameIs(Field f, String name) {
        return Try.of(() -> check(f, () -> f.getName().contentEquals(name)))
                .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);
    }

    private boolean propertyValueIs(Field f, String name, Object value) {
        return Try.of(() -> check(f, () -> f.getName().contentEquals(name) && f.get(this.term.value()).equals(value)))
                .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);
    }

    boolean hasNullProperties() {
        return this.fields().anyMatch(this::isNull);
    }

    boolean hasAllNullProperties() {
        return this.fields().allMatch(this::isNull);
    }

    boolean hasNoNullProperties() {
        return this.fields().noneMatch(this::isNull);
    }

    boolean hasProperty(String name) {
        return this.fields().anyMatch(f -> this.propertyNameIs(f, name));
    }

    boolean hasPropertyWithValue(String propertyName, Object propertyValue) {
        return this.fields().anyMatch(f -> this.propertyValueIs(f, propertyName, propertyValue));
    }

}
