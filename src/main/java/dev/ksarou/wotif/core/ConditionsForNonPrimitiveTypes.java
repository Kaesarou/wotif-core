/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.iterable.IterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.arrays.*;
import dev.ksarou.wotif.core.condition.typed.map.MapCondition;
import dev.ksarou.wotif.core.condition.typed.map.MapJoinCondition;
import dev.ksarou.wotif.core.condition.typed.object.ObjectCondition;
import dev.ksarou.wotif.core.condition.typed.object.ObjectJoinCondition;
import dev.ksarou.wotif.core.condition.typed.string.StringCondition;
import dev.ksarou.wotif.core.condition.typed.string.StringJoinCondition;

import java.util.Map;

class ConditionsForNonPrimitiveTypes extends ConditionsForPrimitiveTypes {

    //String
    public static StringCondition when(String term) {
        return new StringCondition(term);
    }

    public static StringJoinCondition whenAnyOf(String... terms) {
        return new StringJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static StringJoinCondition whenAllOf(String... terms) {
        return new StringJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static StringJoinCondition whenNoneOf(String... terms) {
        return new StringJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays object
    public static <T> ArraysCondition<T> when(T[] term) {
        return new ArraysCondition<>(term);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> whenAnyOf(T[]... terms) {
        return new ArraysJoinCondition<>(JoinEnum.ANYOF, terms);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> whenAllOf(T[]... terms) {
        return new ArraysJoinCondition<>(JoinEnum.ALLOF, terms);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> whenNoneOf(T[]... terms) {
        return new ArraysJoinCondition<>(JoinEnum.NONEOF, terms);
    }

    //Arrays boolean
    public static BooleanArraysCondition when(boolean[] term) {
        return new BooleanArraysCondition(term);
    }

    public static BooleanArraysJoinCondition whenAnyOf(boolean[]... terms) {
        return new BooleanArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static BooleanArraysJoinCondition whenAllOf(boolean[]... terms) {
        return new BooleanArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static BooleanArraysJoinCondition whenNoneOf(boolean[]... terms) {
        return new BooleanArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays byte
    public static ByteArraysCondition when(byte[] term) {
        return new ByteArraysCondition(term);
    }

    public static ByteArraysJoinCondition whenAnyOf(byte[]... terms) {
        return new ByteArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static ByteArraysJoinCondition whenAllOf(byte[]... terms) {
        return new ByteArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static ByteArraysJoinCondition whenNoneOf(byte[]... terms) {
        return new ByteArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays char
    public static CharArraysCondition when(char[] term) {
        return new CharArraysCondition(term);
    }

    public static CharArraysJoinCondition whenAnyOf(char[]... terms) {
        return new CharArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static CharArraysJoinCondition whenAllOf(char[]... terms) {
        return new CharArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static CharArraysJoinCondition whenNoneOf(char[]... terms) {
        return new CharArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays double
    public static DoubleArraysCondition when(double[] term) {
        return new DoubleArraysCondition(term);
    }

    public static DoubleArraysJoinCondition whenAnyOf(double[]... terms) {
        return new DoubleArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static DoubleArraysJoinCondition whenAllOf(double[]... terms) {
        return new DoubleArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static DoubleArraysJoinCondition whenNoneOf(double[]... terms) {
        return new DoubleArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays float
    public static FloatArraysCondition when(float[] term) {
        return new FloatArraysCondition(term);
    }

    public static FloatArraysJoinCondition whenAnyOf(float[]... terms) {
        return new FloatArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static FloatArraysJoinCondition whenAllOf(float[]... terms) {
        return new FloatArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static FloatArraysJoinCondition whenNoneOf(float[]... terms) {
        return new FloatArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays int
    public static IntArraysCondition when(int[] term) {
        return new IntArraysCondition(term);
    }

    public static IntArraysJoinCondition whenAnyOf(int[]... terms) {
        return new IntArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static IntArraysJoinCondition whenAllOf(int[]... terms) {
        return new IntArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static IntArraysJoinCondition whenNoneOf(int[]... terms) {
        return new IntArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays long
    public static LongArraysCondition when(long[] term) {
        return new LongArraysCondition(term);
    }

    public static LongArraysJoinCondition whenAnyOf(long[]... terms) {
        return new LongArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static LongArraysJoinCondition whenAllOf(long[]... terms) {
        return new LongArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static LongArraysJoinCondition whenNoneOf(long[]... terms) {
        return new LongArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Arrays short
    public static ShortArraysCondition when(short[] term) {
        return new ShortArraysCondition(term);
    }

    public static ShortArraysJoinCondition whenAnyOf(short[]... terms) {
        return new ShortArraysJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static ShortArraysJoinCondition whenAllOf(short[]... terms) {
        return new ShortArraysJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static ShortArraysJoinCondition whenNoneOf(short[]... terms) {
        return new ShortArraysJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Iterables
    public static <T> IterableCondition<T> when(Iterable<T> term) {
        return new IterableCondition<>(term);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> whenAnyOf(Iterable<T>... terms) {
        return new IterableJoinCondition<>(JoinEnum.ANYOF, terms);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> whenAllOf(Iterable<T>... terms) {
        return new IterableJoinCondition<>(JoinEnum.ALLOF, terms);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> whenNoneOf(Iterable<T>... terms) {
        return new IterableJoinCondition<>(JoinEnum.NONEOF, terms);
    }

    //Maps
    public static <KEY, VALUE> MapCondition<KEY, VALUE> when(Map<KEY, VALUE> term) {
        return new MapCondition<>(term);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> whenAnyOf(Map<KEY, VALUE>... terms) {
        return new MapJoinCondition<>(JoinEnum.ANYOF, terms);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> whenAllOf(Map<KEY, VALUE>... terms) {
        return new MapJoinCondition<>(JoinEnum.ALLOF, terms);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> whenNoneOf(Map<KEY, VALUE>... terms) {
        return new MapJoinCondition<>(JoinEnum.NONEOF, terms);
    }

    //String
    public static <T> ObjectCondition<T> when(T term) {
        return new ObjectCondition<>(term);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> whenAnyOf(T... terms) {
        return new ObjectJoinCondition<>(JoinEnum.ANYOF, terms);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> whenAllOf(T... terms) {
        return new ObjectJoinCondition<>(JoinEnum.ALLOF, terms);
    }

    @SafeVarargs
    static <T> ObjectJoinCondition<T> whenNoneOf(T... terms) {
        return new ObjectJoinCondition<>(JoinEnum.NONEOF, terms);
    }
}
