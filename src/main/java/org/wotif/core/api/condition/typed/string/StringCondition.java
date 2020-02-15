package org.wotif.core.api.condition.typed.string;

import org.apache.commons.lang3.StringUtils;
import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.ComparableCondition;

public class StringCondition extends ComparableCondition<String> implements IStringCondition<String> {

    public StringCondition(String term) {
        super(term);
    }

    @Override
    public CompletableResult<String> contains(String contains) {
        boolean value = this.term.value().contains(contains);
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> containsIgnoringCase(String contains) {
        boolean value = StringUtils.containsIgnoreCase(this.term.value(), contains);
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> notContains(String notContains) {
        boolean value = !this.term.value().contains(notContains);
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isEmpty() {
        boolean value = this.term.value().isEmpty();
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isNotEmpty() {
        boolean value = !this.term.value().isEmpty();
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isContainedIn(String stringContainer) {
        boolean value = stringContainer.contains(this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isNotContainedIn(String stringContainer) {
        boolean value = !stringContainer.contains(this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isContainedInIgnoreCase(String stringContainer) {
        boolean value = StringUtils.containsIgnoreCase(stringContainer, this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isNotContainedInIgnoreCase(String stringContainer) {
        boolean value = !StringUtils.containsIgnoreCase(stringContainer, this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isContainedInSubstring(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer, start, end);
        boolean value = StringUtils.contains(substring, this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer.toLowerCase(), start.toLowerCase(), end.toLowerCase());
        boolean value = StringUtils.containsIgnoreCase(substring, this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isNotContainedInSubstring(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer, start, end);
        boolean value = !StringUtils.contains(substring, this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isNotContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        String substring = StringUtils.substringBetween(stringContainer.toLowerCase(), start.toLowerCase(), end.toLowerCase());
        boolean value = !StringUtils.containsIgnoreCase(substring, this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isEqualToIgnoringCase(String string) {
        boolean value = StringUtils.equalsIgnoreCase(this.term.value(), string);
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isDifferentFromIgnoringCase(String string) {
        boolean value = !StringUtils.equalsIgnoreCase(this.term.value(), string);
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isBlank() {
        boolean value = this.term.value().isBlank();
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<String> isNotBlank() {
        boolean value = !this.term.value().isBlank();
        return new CompletableResult<>(term, value);
    }

}
