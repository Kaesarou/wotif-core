package dev.ksarou.wotif.core.condition.typed.temporal;

import java.time.LocalDateTime;

public class InternalTemporalCondition {

    LocalDateTime localDateTime;

    public boolean isAfter(LocalDateTime other) {
        return this.localDateTime.isAfter(other);
    }

    public boolean isAfterOrEqualTo(LocalDateTime other) {
        return this.localDateTime.isAfter(other) || this.localDateTime.isEqual(other);
    }

    public boolean isBefore(LocalDateTime other) {
        return this.localDateTime.isBefore(other);
    }

    public boolean isBeforeOrEqualTo(LocalDateTime other) {
        return this.localDateTime.isBefore(other) || this.localDateTime.isEqual(other);
    }

    public boolean isBetween(LocalDateTime inclusiveStart, LocalDateTime inclusiveEnd) {
        return false;
    }

    public boolean isStrictlyBetween(LocalDateTime inclusiveStart, LocalDateTime inclusiveEnd) {
        return false;
    }

    public boolean isToday() {
        return false;
    }
}
