package org.wotif.core.api.controls;

import io.vavr.control.Option;

import java.util.function.Function;

public class MapControl<T, R> {

    private final Option<T> value;

    private final Function<? super T, ? extends R> mapper;

    public MapControl(Option<T> value, Function<? super T, ? extends R> mapper) {
        this.value = value;
        this.mapper = mapper;
    }

    public MapControl<T, R> orElse(Function<? super T, ? extends R> mapper) {
        if (mapper == null)
            return this;
        return new MapControl<>(this.value, mapper);
    }

    public R end() {
        return this.value.map(this.mapper).getOrNull();
    }

}
