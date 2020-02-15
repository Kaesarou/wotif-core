package org.wotif.core.api.condition.typed.string;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.ComparableJoinCondition;

import java.util.List;

public class StringJoinCondition extends ComparableJoinCondition<String, StringCondition>
        implements IStringCondition<List<String>> {

    public StringJoinCondition(JoinEnum joinType, String... terms) {
        super(joinType, terms);
    }

    @Override
    protected StringCondition getInstanceOfCondition(String term) {
        return new StringCondition(term);
    }

    @Override
    public CompletableResult<List<String>> contains(String contains) {
        return this.functionToApply.apply(s -> s.contains(contains));
    }

    @Override
    public CompletableResult<List<String>> containsIgnoringCase(String contains) {
        return this.functionToApply.apply(s -> s.containsIgnoringCase(contains));
    }

    @Override
    public CompletableResult<List<String>> notContains(String notContains) {
        return this.functionToApply.apply(s -> s.notContains(notContains));
    }

    @Override
    public CompletableResult<List<String>> isEmpty() {
        return this.functionToApply.apply(StringCondition::isEmpty);
    }

    @Override
    public CompletableResult<List<String>> isNotEmpty() {
        return this.functionToApply.apply(StringCondition::isNotEmpty);
    }

    @Override
    public CompletableResult<List<String>> isContainedIn(String stringContainer) {
        return this.functionToApply.apply(s -> s.isContainedIn(stringContainer));
    }

    @Override
    public CompletableResult<List<String>> isNotContainedIn(String stringContainer) {
        return this.functionToApply.apply(s -> s.isNotContainedIn(stringContainer));
    }

    @Override
    public CompletableResult<List<String>> isContainedInIgnoreCase(String stringContainer) {
        return this.functionToApply.apply(s -> s.isContainedInIgnoreCase(stringContainer));
    }

    @Override
    public CompletableResult<List<String>> isNotContainedInIgnoreCase(String stringContainer) {
        return this.functionToApply.apply(s -> s.isNotContainedInIgnoreCase(stringContainer));
    }

    @Override
    public CompletableResult<List<String>> isContainedInSubstring(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isContainedInSubstring(stringContainer, start, end));
    }

    @Override
    public CompletableResult<List<String>> isContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isContainedInSubstringIgnoreCase(stringContainer, start, end));
    }

    @Override
    public CompletableResult<List<String>> isNotContainedInSubstring(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isNotContainedInSubstring(stringContainer, start, end));
    }

    @Override
    public CompletableResult<List<String>> isNotContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isNotContainedInSubstringIgnoreCase(stringContainer, start, end));
    }

    @Override
    public CompletableResult<List<String>> isEqualToIgnoringCase(String string) {
        return this.functionToApply.apply(s -> s.isEqualToIgnoringCase(string));
    }

    @Override
    public CompletableResult<List<String>> isDifferentFromIgnoringCase(String string) {
        return this.functionToApply.apply(s -> s.isDifferentFromIgnoringCase(string));
    }

    @Override
    public CompletableResult<List<String>> isBlank() {
        return this.functionToApply.apply(StringCondition::isBlank);
    }

    @Override
    public CompletableResult<List<String>> isNotBlank() {
        return this.functionToApply.apply(StringCondition::isNotBlank);
    }

}
