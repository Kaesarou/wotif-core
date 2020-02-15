package org.wotif.core.api.condition.typed.string;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.IComparableCondition;

public interface IStringCondition<R> extends IComparableCondition<String, R> {

    CompletableResult<R> contains(String contains);

    CompletableResult<R> containsIgnoringCase(String contains);

    CompletableResult<R> notContains(String notContains);

    CompletableResult<R> isEmpty();

    CompletableResult<R> isNotEmpty();

    CompletableResult<R> isContainedIn(String stringContainer);

    CompletableResult<R> isNotContainedIn(String stringContainer);

    CompletableResult<R> isContainedInIgnoreCase(String stringContainer);

    CompletableResult<R> isNotContainedInIgnoreCase(String stringContainer);

    CompletableResult<R> isContainedInSubstring(String stringContainer, String start, String end);

    CompletableResult<R> isContainedInSubstringIgnoreCase(String stringContainer, String start, String end);

    CompletableResult<R> isNotContainedInSubstring(String stringContainer, String start, String end);

    CompletableResult<R> isNotContainedInSubstringIgnoreCase(String stringContainer, String start, String end);

    CompletableResult<R> isEqualToIgnoringCase(String string);

    CompletableResult<R> isDifferentFromIgnoringCase(String string);

    CompletableResult<R> isBlank();

    CompletableResult<R> isNotBlank();

}
