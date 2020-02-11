package org.wotif.core.api;

import org.wotif.core.api.condition.typed.booleans.BooleanCondition;
import org.wotif.core.api.condition.typed.booleans.BooleanJoinCondition;
import org.wotif.core.api.condition.typed.character.CharacterCondition;
import org.wotif.core.api.condition.typed.character.CharacterJoinCondition;
import org.wotif.core.api.condition.typed.iterable.IterableCondition;
import org.wotif.core.api.condition.typed.iterable.IterableJoinCondition;
import org.wotif.core.api.condition.typed.iterable.arrays.*;
import org.wotif.core.api.condition.typed.map.MapCondition;
import org.wotif.core.api.condition.typed.map.MapJoinCondition;
import org.wotif.core.api.condition.typed.number.bytes.ByteCondition;
import org.wotif.core.api.condition.typed.number.bytes.ByteJoinCondition;
import org.wotif.core.api.condition.typed.number.floating.doubles.DoubleCondition;
import org.wotif.core.api.condition.typed.number.floating.doubles.DoubleJoinCondition;
import org.wotif.core.api.condition.typed.number.floating.floats.FloatCondition;
import org.wotif.core.api.condition.typed.number.floating.floats.FloatJoinCondition;
import org.wotif.core.api.condition.typed.number.integer.IntegerCondition;
import org.wotif.core.api.condition.typed.number.integer.IntegerJoinCondition;
import org.wotif.core.api.condition.typed.number.longs.LongCondition;
import org.wotif.core.api.condition.typed.number.longs.LongJoinCondition;
import org.wotif.core.api.condition.typed.number.shorts.ShortCondition;
import org.wotif.core.api.condition.typed.number.shorts.ShortJoinCondition;
import org.wotif.core.api.condition.typed.object.ObjectCondition;
import org.wotif.core.api.condition.typed.object.ObjectJoinCondition;
import org.wotif.core.api.condition.typed.string.StringCondition;
import org.wotif.core.api.condition.typed.string.StringJoinCondition;

import java.util.Map;

public class Conditions {

    private Conditions() {
    }

    //Boolean
    public static BooleanCondition checkIf(Boolean term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static BooleanJoinCondition checkIfAnyOf(Boolean... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static BooleanJoinCondition checkIfAllOf(Boolean... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static BooleanJoinCondition checkIfNoneOf(Boolean... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //String
    public static StringCondition checkIf(String term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static StringJoinCondition checkIfAnyOf(String... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static StringJoinCondition checkIfAllOf(String... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static StringJoinCondition checkIfNoneOf(String... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Integer
    public static IntegerCondition checkIf(Integer term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static IntegerJoinCondition checkIfAnyOf(Integer... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static IntegerJoinCondition checkIfAllOf(Integer... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static IntegerJoinCondition checkIfNoneOf(Integer... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Double
    public static DoubleCondition checkIf(Double term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static DoubleJoinCondition checkIfAnyOf(Double... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static DoubleJoinCondition checkIfAllOf(Double... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static DoubleJoinCondition checkIfNoneOf(Double... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Double
    public static FloatCondition checkIf(Float term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static FloatJoinCondition checkIfAnyOf(Float... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static FloatJoinCondition checkIfAllOf(Float... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static FloatJoinCondition checkIfNoneOf(Float... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Short
    public static ShortCondition checkIf(Short term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static ShortJoinCondition checkIfAnyOf(Short... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static ShortJoinCondition checkIfAllOf(Short... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static ShortJoinCondition checkIfNoneOf(Short... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Byte
    public static ByteCondition checkIf(Byte term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static ByteJoinCondition checkIfAnyOf(Byte... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static ByteJoinCondition checkIfAllOf(Byte... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static ByteJoinCondition checkIfNoneOf(Byte... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Long
    public static LongCondition checkIf(Long term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static LongJoinCondition checkIfAnyOf(Long... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static LongJoinCondition checkIfAllOf(Long... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static LongJoinCondition checkIfNoneOf(Long... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Character
    public static CharacterCondition checkIf(Character term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static CharacterJoinCondition checkIfAnyOf(Character... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static CharacterJoinCondition checkIfAllOf(Character... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static CharacterJoinCondition checkIfNoneOf(Character... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays Generic
    public static <T> ArraysCondition<T> checkIf(T[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> checkIfAnyOf(T[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> checkIfAllOf(T[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    @SafeVarargs
    public static <T> ArraysJoinCondition<T> checkIfNoneOf(T[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays boolean
    public static BooleanArraysCondition checkIf(boolean[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static BooleanArraysJoinCondition checkIfAnyOf(boolean[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static BooleanArraysJoinCondition checkIfAllOf(boolean[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static BooleanArraysJoinCondition checkIfNoneOf(boolean[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays byte
    public static ByteArraysCondition checkIf(byte[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static ByteArraysJoinCondition checkIfAnyOf(byte[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static ByteArraysJoinCondition checkIfAllOf(byte[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static ByteArraysJoinCondition checkIfNoneOf(byte[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays char
    public static CharArraysCondition checkIf(char[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static CharArraysJoinCondition checkIfAnyOf(char[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static CharArraysJoinCondition checkIfAllOf(char[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static CharArraysJoinCondition checkIfNoneOf(char[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays double
    public static DoubleArraysCondition checkIf(double[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static DoubleArraysJoinCondition checkIfAnyOf(double[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static DoubleArraysJoinCondition checkIfAllOf(double[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static DoubleArraysJoinCondition checkIfNoneOf(double[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays float
    public static FloatArraysCondition checkIf(float[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static FloatArraysJoinCondition checkIfAnyOf(float[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static FloatArraysJoinCondition checkIfAllOf(float[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static FloatArraysJoinCondition checkIfNoneOf(float[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays int
    public static IntArraysCondition checkIf(int[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static IntArraysJoinCondition checkIfAnyOf(int[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static IntArraysJoinCondition checkIfAllOf(int[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static IntArraysJoinCondition checkIfNoneOf(int[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays long
    public static LongArraysCondition checkIf(long[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static LongArraysJoinCondition checkIfAnyOf(long[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static LongArraysJoinCondition checkIfAllOf(long[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static LongArraysJoinCondition checkIfNoneOf(long[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Arrays short
    public static ShortArraysCondition checkIf(short[] term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    public static ShortArraysJoinCondition checkIfAnyOf(short[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    public static ShortArraysJoinCondition checkIfAllOf(short[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    public static ShortArraysJoinCondition checkIfNoneOf(short[]... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Iterables
    public static <T> IterableCondition<T> checkIf(Iterable<T> term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> checkIfAnyOf(Iterable<T>... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> checkIfAllOf(Iterable<T>... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    @SafeVarargs
    public static <T> IterableJoinCondition<T> checkIfNoneOf(Iterable<T>... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //Map
    public static <KEY, VALUE> MapCondition<KEY, VALUE> checkIf(Map<KEY, VALUE> term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> checkIfAnyOf(Map<KEY, VALUE>... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> checkIfAllOf(Map<KEY, VALUE>... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    @SafeVarargs
    public static <KEY, VALUE> MapJoinCondition<KEY, VALUE> checkIfNoneOf(Map<KEY, VALUE>... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }

    //String
    public static <T> ObjectCondition<T> checkIf(T term) {
        return ConditionsForNonPrimitiveTypes.checkIf(term);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> checkIfAnyOf(T... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAnyOf(terms);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> checkIfAllOf(T... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfAllOf(terms);
    }

    @SafeVarargs
    public static <T> ObjectJoinCondition<T> checkIfNoneOf(T... terms) {
        return ConditionsForNonPrimitiveTypes.checkIfNoneOf(terms);
    }
}


