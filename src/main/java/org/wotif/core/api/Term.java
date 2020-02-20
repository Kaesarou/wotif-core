package org.wotif.core.api;

public class Term <T> {

    private final T value;

    public Term(T term) { this.value = term; }

    public T value() { return this.value; }

}
