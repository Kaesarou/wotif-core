/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.string;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.IComparableCondition;

public interface IStringCondition<R> extends IComparableCondition<String, R> {

    Completable<R> contains(String contains);

    Completable<R> containsIgnoringCase(String contains);

    Completable<R> notContains(String notContains);

    Completable<R> isEmpty();

    Completable<R> isNotEmpty();

    Completable<R> isContainedIn(String stringContainer);

    Completable<R> isNotContainedIn(String stringContainer);

    Completable<R> isContainedInIgnoreCase(String stringContainer);

    Completable<R> isNotContainedInIgnoreCase(String stringContainer);

    Completable<R> isContainedInSubstring(String stringContainer, String start, String end);

    Completable<R> isContainedInSubstringIgnoreCase(String stringContainer, String start, String end);

    Completable<R> isNotContainedInSubstring(String stringContainer, String start, String end);

    Completable<R> isNotContainedInSubstringIgnoreCase(String stringContainer, String start, String end);

    Completable<R> isEqualToIgnoringCase(String string);

    Completable<R> isDifferentFromIgnoringCase(String string);

    Completable<R> isBlank();

    Completable<R> isNotBlank();

}
