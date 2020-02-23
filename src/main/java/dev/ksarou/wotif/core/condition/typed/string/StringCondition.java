package dev.ksarou.wotif.core.condition.typed.string;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.ComparableCondition;
import org.apache.commons.lang3.StringUtils;

public class StringCondition extends ComparableCondition<String> implements IStringCondition<String> {

    public StringCondition(String term) {
        super(term);
    }

    @Override
    public Completable<String> contains(String contains) {
        boolean value = this.term.value().contains(contains);
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> containsIgnoringCase(String contains) {
        boolean value = StringUtils.containsIgnoreCase(this.term.value(), contains);
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> notContains(String notContains) {
        boolean value = !this.term.value().contains(notContains);
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isEmpty() {
        boolean value = this.term.value().isEmpty();
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isNotEmpty() {
        boolean value = !this.term.value().isEmpty();
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isContainedIn(String stringContainer) {
        boolean value = stringContainer.contains(this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isNotContainedIn(String stringContainer) {
        boolean value = !stringContainer.contains(this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isContainedInIgnoreCase(String stringContainer) {
        boolean value = StringUtils.containsIgnoreCase(stringContainer, this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isNotContainedInIgnoreCase(String stringContainer) {
        boolean value = !StringUtils.containsIgnoreCase(stringContainer, this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isContainedInSubstring(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer, start, end);
        boolean value = StringUtils.contains(substring, this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer.toLowerCase(), start.toLowerCase(), end.toLowerCase());
        boolean value = StringUtils.containsIgnoreCase(substring, this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isNotContainedInSubstring(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer, start, end);
        boolean value = !StringUtils.contains(substring, this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isNotContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer.toLowerCase(), start.toLowerCase(), end.toLowerCase());
        boolean value = !StringUtils.containsIgnoreCase(substring, this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isEqualToIgnoringCase(String string) {
        boolean value = StringUtils.equalsIgnoreCase(this.term.value(), string);
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isDifferentFromIgnoringCase(String string) {
        boolean value = !StringUtils.equalsIgnoreCase(this.term.value(), string);
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isBlank() {
        boolean value = this.term.value().isBlank();
        return new Completable<>(term, value);
    }

    @Override
    public Completable<String> isNotBlank() {
        boolean value = !this.term.value().isBlank();
        return new Completable<>(term, value);
    }

}
