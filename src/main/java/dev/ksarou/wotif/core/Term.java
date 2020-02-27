/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class Term is a
 * container class for all terms used in condition evaluation
 * @author Cesare de Padua
 * Created on 24/02/2020
 */
public class Term<T> {

    private final T value;

    public Term(T term) {
        this.value = term;
    }

    public T value() {
        return this.value;
    }

    /**
     * Method concat transform the value of a term into a list
     * and add another term value to it (it is used with logical operators)
     * @param term of type Term<?> contains the term to concat
     * @return Term<?>
     */
    public Term<?> concat(Term<?> term) {
        List<Object> squashedTerms = new ArrayList<>();
        if (this.value instanceof Collection) squashedTerms.addAll((Collection<?>) this.value);
        else squashedTerms.add(this.value);
        if (term.value() instanceof Collection) squashedTerms.addAll((Collection<?>) term.value());
        else squashedTerms.add(term.value());
        return new Term<>(squashedTerms);
    }

}
