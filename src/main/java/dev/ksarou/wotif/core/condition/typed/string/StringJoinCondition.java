package dev.ksarou.wotif.core.condition.typed.string;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.ComparableJoinCondition;

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
    public Completable<List<String>> contains(String contains) {
        return this.functionToApply.apply(s -> s.contains(contains));
    }

    @Override
    public Completable<List<String>> containsIgnoringCase(String contains) {
        return this.functionToApply.apply(s -> s.containsIgnoringCase(contains));
    }

    @Override
    public Completable<List<String>> notContains(String notContains) {
        return this.functionToApply.apply(s -> s.notContains(notContains));
    }

    @Override
    public Completable<List<String>> isEmpty() {
        return this.functionToApply.apply(StringCondition::isEmpty);
    }

    @Override
    public Completable<List<String>> isNotEmpty() {
        return this.functionToApply.apply(StringCondition::isNotEmpty);
    }

    @Override
    public Completable<List<String>> isContainedIn(String stringContainer) {
        return this.functionToApply.apply(s -> s.isContainedIn(stringContainer));
    }

    @Override
    public Completable<List<String>> isNotContainedIn(String stringContainer) {
        return this.functionToApply.apply(s -> s.isNotContainedIn(stringContainer));
    }

    @Override
    public Completable<List<String>> isContainedInIgnoreCase(String stringContainer) {
        return this.functionToApply.apply(s -> s.isContainedInIgnoreCase(stringContainer));
    }

    @Override
    public Completable<List<String>> isNotContainedInIgnoreCase(String stringContainer) {
        return this.functionToApply.apply(s -> s.isNotContainedInIgnoreCase(stringContainer));
    }

    @Override
    public Completable<List<String>> isContainedInSubstring(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isContainedInSubstring(stringContainer, start, end));
    }

    @Override
    public Completable<List<String>> isContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isContainedInSubstringIgnoreCase(stringContainer, start, end));
    }

    @Override
    public Completable<List<String>> isNotContainedInSubstring(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isNotContainedInSubstring(stringContainer, start, end));
    }

    @Override
    public Completable<List<String>> isNotContainedInSubstringIgnoreCase(String stringContainer, String start, String end) {
        return this.functionToApply.apply(s -> s.isNotContainedInSubstringIgnoreCase(stringContainer, start, end));
    }

    @Override
    public Completable<List<String>> isEqualToIgnoringCase(String string) {
        return this.functionToApply.apply(s -> s.isEqualToIgnoringCase(string));
    }

    @Override
    public Completable<List<String>> isDifferentFromIgnoringCase(String string) {
        return this.functionToApply.apply(s -> s.isDifferentFromIgnoringCase(string));
    }

    @Override
    public Completable<List<String>> isBlank() {
        return this.functionToApply.apply(StringCondition::isBlank);
    }

    @Override
    public Completable<List<String>> isNotBlank() {
        return this.functionToApply.apply(StringCondition::isNotBlank);
    }

}
