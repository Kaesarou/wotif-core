package dev.ksarou.wotif.core.condition.typed.time;

import dev.ksarou.wotif.core.condition.typed.IComparableCondition;

public interface ITimeCondition<T extends Comparable<T>, R>
        extends IComparableCondition<T, R> {
}
