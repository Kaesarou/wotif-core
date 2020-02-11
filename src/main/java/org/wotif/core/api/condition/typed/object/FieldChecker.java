package org.wotif.core.api.condition.typed.object;

@FunctionalInterface
interface FieldChecker {

    boolean check() throws IllegalAccessException;

}
