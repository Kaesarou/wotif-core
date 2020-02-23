package dev.ksarou.wotif.core;

import dev.ksarou.wotif.core.condition.typed.booleans.BooleanCondition;
import dev.ksarou.wotif.core.condition.typed.booleans.BooleanJoinCondition;
import dev.ksarou.wotif.core.condition.typed.character.CharacterCondition;
import dev.ksarou.wotif.core.condition.typed.character.CharacterJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.arrays.*;
import dev.ksarou.wotif.core.condition.typed.map.MapCondition;
import dev.ksarou.wotif.core.condition.typed.map.MapJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.bytes.ByteCondition;
import dev.ksarou.wotif.core.condition.typed.number.bytes.ByteJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.doubles.DoubleCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.doubles.DoubleJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.floats.FloatCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.floats.FloatJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.integer.IntegerCondition;
import dev.ksarou.wotif.core.condition.typed.number.integer.IntegerJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.longs.LongCondition;
import dev.ksarou.wotif.core.condition.typed.number.longs.LongJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.shorts.ShortCondition;
import dev.ksarou.wotif.core.condition.typed.number.shorts.ShortJoinCondition;
import dev.ksarou.wotif.core.condition.typed.object.ObjectCondition;
import dev.ksarou.wotif.core.condition.typed.object.ObjectJoinCondition;
import dev.ksarou.wotif.core.condition.typed.string.StringCondition;
import dev.ksarou.wotif.core.condition.typed.string.StringJoinCondition;

import java.util.Map;

public class Conditions {

    private Conditions() {
    }

    //Boolean
    public static BooleanCondition when(Boolean term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static BooleanJoinCondition whenAnyOf(Boolean... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static BooleanJoinCondition whenAllOf(Boolean... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static BooleanJoinCondition whenNoneOf(Boolean... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //String
    public static StringCondition when(String term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static StringJoinCondition whenAnyOf(String... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static StringJoinCondition whenAllOf(String... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static StringJoinCondition whenNoneOf(String... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Integer
    public static IntegerCondition when(Integer term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static IntegerJoinCondition whenAnyOf(Integer... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static IntegerJoinCondition whenAllOf(Integer... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static IntegerJoinCondition whenNoneOf(Integer... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Double
    public static DoubleCondition when(Double term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static DoubleJoinCondition whenAnyOf(Double... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static DoubleJoinCondition whenAllOf(Double... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static DoubleJoinCondition whenNoneOf(Double... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Double
    public static FloatCondition when(Float term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static FloatJoinCondition whenAnyOf(Float... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static FloatJoinCondition whenAllOf(Float... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static FloatJoinCondition whenNoneOf(Float... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Short
    public static ShortCondition when(Short term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static ShortJoinCondition whenAnyOf(Short... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static ShortJoinCondition whenAllOf(Short... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static ShortJoinCondition whenNoneOf(Short... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Byte
    public static ByteCondition when(Byte term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static ByteJoinCondition whenAnyOf(Byte... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static ByteJoinCondition whenAllOf(Byte... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static ByteJoinCondition whenNoneOf(Byte... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Long
    public static LongCondition when(Long term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static LongJoinCondition whenAnyOf(Long... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static LongJoinCondition whenAllOf(Long... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static LongJoinCondition whenNoneOf(Long... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Character
    public static CharacterCondition when(Character term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static CharacterJoinCondition whenAnyOf(Character... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static CharacterJoinCondition whenAllOf(Character... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static CharacterJoinCondition whenNoneOf(Character... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays Generic
    public static <T> ArraysCondition<T> when(T[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> whenAnyOf(T[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> whenAllOf(T[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> whenNoneOf(T[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays boolean
    public static BooleanArraysCondition when(boolean[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static BooleanArraysJoinCondition whenAnyOf(boolean[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static BooleanArraysJoinCondition whenAllOf(boolean[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static BooleanArraysJoinCondition whenNoneOf(boolean[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays byte
    public static ByteArraysCondition when(byte[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static ByteArraysJoinCondition whenAnyOf(byte[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static ByteArraysJoinCondition whenAllOf(byte[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static ByteArraysJoinCondition whenNoneOf(byte[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays char
    public static CharArraysCondition when(char[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static CharArraysJoinCondition whenAnyOf(char[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static CharArraysJoinCondition whenAllOf(char[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static CharArraysJoinCondition whenNoneOf(char[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays double
    public static DoubleArraysCondition when(double[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static DoubleArraysJoinCondition whenAnyOf(double[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static DoubleArraysJoinCondition whenAllOf(double[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static DoubleArraysJoinCondition whenNoneOf(double[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays float
    public static FloatArraysCondition when(float[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static FloatArraysJoinCondition whenAnyOf(float[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static FloatArraysJoinCondition whenAllOf(float[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static FloatArraysJoinCondition whenNoneOf(float[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays int
    public static IntArraysCondition when(int[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static IntArraysJoinCondition whenAnyOf(int[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static IntArraysJoinCondition whenAllOf(int[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static IntArraysJoinCondition whenNoneOf(int[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays long
    public static LongArraysCondition when(long[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static LongArraysJoinCondition whenAnyOf(long[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static LongArraysJoinCondition whenAllOf(long[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static LongArraysJoinCondition whenNoneOf(long[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Arrays short
    public static ShortArraysCondition when(short[] term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    public static ShortArraysJoinCondition whenAnyOf(short[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    public static ShortArraysJoinCondition whenAllOf(short[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    public static ShortArraysJoinCondition whenNoneOf(short[]... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Iterables
    public static <T> IterableCondition<T> when(Iterable<T> term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> whenAnyOf(Iterable<T>... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> whenAllOf(Iterable<T>... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> whenNoneOf(Iterable<T>... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //Map
    public static <KEY, VALUE> MapCondition<KEY, VALUE> when(Map<KEY, VALUE> term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> whenAnyOf(Map<KEY, VALUE>... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> whenAllOf(Map<KEY, VALUE>... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> whenNoneOf(Map<KEY, VALUE>... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

    //String
    public static <T> ObjectCondition<T> when(T term) {
        return ConditionsForNonPrimitiveTypes.when(term);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> whenAnyOf(T... terms) {
        return ConditionsForNonPrimitiveTypes.whenAnyOf(terms);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> whenAllOf(T... terms) {
        return ConditionsForNonPrimitiveTypes.whenAllOf(terms);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> whenNoneOf(T... terms) {
        return ConditionsForNonPrimitiveTypes.whenNoneOf(terms);
    }

}


