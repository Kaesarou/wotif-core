package org.wotif.core.api;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.iterables.IterableCondition;
import org.wotif.core.api.condition.typed.iterables.IterableJoinCondition;
import org.wotif.core.api.condition.typed.iterables.arrays.*;
import org.wotif.core.api.condition.typed.string.StringCondition;
import org.wotif.core.api.condition.typed.string.StringJoinCondition;

class ConditionsForNonPrimitiveTypes extends ConditionsForPrimitiveTypes {

    //String
    public static StringCondition checkIf(String term) { return new StringCondition(term); }
    public static StringJoinCondition checkIfAnyOf(String... terms) { return new StringJoinCondition(JoinEnum.ANYOF, terms); }
    public static StringJoinCondition checkIfAllOf(String... terms) { return new StringJoinCondition(JoinEnum.ALLOF, terms); }
    public static StringJoinCondition checkIfNoneOf(String... terms) { return new StringJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays object
    public static <T> ArraysCondition<T> checkIf(T[] term) { return new ArraysCondition<>(term); }
    @SafeVarargs
    public static <T>ArraysJoinCondition<T> checkIfAnyOf(T[]... terms) { return new ArraysJoinCondition<>(JoinEnum.ANYOF, terms); }
    @SafeVarargs
    public static <T>ArraysJoinCondition<T> checkIfAllOf(T[]... terms) { return new ArraysJoinCondition<>(JoinEnum.ALLOF, terms); }
    @SafeVarargs
    public static <T>ArraysJoinCondition<T> checkIfNoneOf(T[]... terms) { return new ArraysJoinCondition<>(JoinEnum.NONEOF, terms); }
    //Arrays boolean
    public static BooleanArraysCondition checkIf(boolean[] term) { return new BooleanArraysCondition(term); }
    public static BooleanArraysJoinCondition checkIfAnyOf(boolean[]... terms) { return new BooleanArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static BooleanArraysJoinCondition checkIfAllOf(boolean[]... terms) { return new BooleanArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static BooleanArraysJoinCondition checkIfNoneOf(boolean[]... terms) { return new BooleanArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays byte
    public static ByteArraysCondition checkIf(byte[] term) { return new ByteArraysCondition(term); }
    public static ByteArraysJoinCondition checkIfAnyOf(byte[]... terms) { return new ByteArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static ByteArraysJoinCondition checkIfAllOf(byte[]... terms) { return new ByteArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static ByteArraysJoinCondition checkIfNoneOf(byte[]... terms) { return new ByteArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays char
    public static CharArraysCondition checkIf(char[] term) { return new CharArraysCondition(term); }
    public static CharArraysJoinCondition checkIfAnyOf(char[]... terms) { return new CharArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static CharArraysJoinCondition checkIfAllOf(char[]... terms) { return new CharArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static CharArraysJoinCondition checkIfNoneOf(char[]... terms) { return new CharArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays double
    public static DoubleArraysCondition checkIf(double[] term) { return new DoubleArraysCondition(term); }
    public static DoubleArraysJoinCondition checkIfAnyOf(double[]... terms) { return new DoubleArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static DoubleArraysJoinCondition checkIfAllOf(double[]... terms) { return new DoubleArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static DoubleArraysJoinCondition checkIfNoneOf(double[]... terms) { return new DoubleArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays float
    public static FloatArraysCondition checkIf(float[] term) { return new FloatArraysCondition(term); }
    public static FloatArraysJoinCondition checkIfAnyOf(float[]... terms) { return new FloatArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static FloatArraysJoinCondition checkIfAllOf(float[]... terms) { return new FloatArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static FloatArraysJoinCondition checkIfNoneOf(float[]... terms) { return new FloatArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays int
    public static IntArraysCondition checkIf(int[] term) { return new IntArraysCondition(term); }
    public static IntArraysJoinCondition checkIfAnyOf(int[]... terms) { return new IntArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static IntArraysJoinCondition checkIfAllOf(int[]... terms) { return new IntArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static IntArraysJoinCondition checkIfNoneOf(int[]... terms) { return new IntArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays long
    public static LongArraysCondition checkIf(long[] term) { return new LongArraysCondition(term); }
    public static LongArraysJoinCondition checkIfAnyOf(long[]... terms) { return new LongArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static LongArraysJoinCondition checkIfAllOf(long[]... terms) { return new LongArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static LongArraysJoinCondition checkIfNoneOf(long[]... terms) { return new LongArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Arrays short
    public static ShortArraysCondition checkIf(short[] term) { return new ShortArraysCondition(term); }
    public static ShortArraysJoinCondition checkIfAnyOf(short[]... terms) { return new ShortArraysJoinCondition(JoinEnum.ANYOF, terms); }
    public static ShortArraysJoinCondition checkIfAllOf(short[]... terms) { return new ShortArraysJoinCondition(JoinEnum.ALLOF, terms); }
    public static ShortArraysJoinCondition checkIfNoneOf(short[]... terms) { return new ShortArraysJoinCondition(JoinEnum.NONEOF, terms); }
    //Iterables
    public static <T> IterableCondition<T> checkIf(Iterable<T> term) { return new IterableCondition<>(term); }
    @SafeVarargs
    public static <T> IterableJoinCondition<T> checkIfAnyOf(Iterable<T>... terms) { return new IterableJoinCondition<>(JoinEnum.ANYOF, terms); }
    @SafeVarargs
    public static <T> IterableJoinCondition<T> checkIfAllOf(Iterable<T>... terms) { return new IterableJoinCondition<>(JoinEnum.ALLOF, terms); }
    @SafeVarargs
    public static <T> IterableJoinCondition<T> checkIfNoneOf(Iterable<T>... terms) { return new IterableJoinCondition<>(JoinEnum.NONEOF, terms); }

}
