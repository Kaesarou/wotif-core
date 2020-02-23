package dev.ksarou.wotif.core.condition.typed.object;

@FunctionalInterface
interface FieldChecker {

    boolean check() throws IllegalAccessException;

}
