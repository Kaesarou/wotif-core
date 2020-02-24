/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.booleans.BooleanCondition;
import dev.ksarou.wotif.core.condition.typed.booleans.BooleanJoinCondition;
import dev.ksarou.wotif.core.condition.typed.character.CharacterCondition;
import dev.ksarou.wotif.core.condition.typed.character.CharacterJoinCondition;
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

class ConditionsForPrimitiveTypes {

    //Boolean
    public static BooleanCondition when(Boolean term) {
        return new BooleanCondition(term);
    }

    public static BooleanJoinCondition whenAnyOf(Boolean... terms) {
        return new BooleanJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static BooleanJoinCondition whenAllOf(Boolean... terms) {
        return new BooleanJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static BooleanJoinCondition whenNoneOf(Boolean... terms) {
        return new BooleanJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Integer
    public static IntegerCondition when(Integer term) {
        return new IntegerCondition(term);
    }

    public static IntegerJoinCondition whenAnyOf(Integer... terms) {
        return new IntegerJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static IntegerJoinCondition whenAllOf(Integer... terms) {
        return new IntegerJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static IntegerJoinCondition whenNoneOf(Integer... terms) {
        return new IntegerJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Double
    public static DoubleCondition when(Double term) {
        return new DoubleCondition(term);
    }

    public static DoubleJoinCondition whenAnyOf(Double... terms) {
        return new DoubleJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static DoubleJoinCondition whenAllOf(Double... terms) {
        return new DoubleJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static DoubleJoinCondition whenNoneOf(Double... terms) {
        return new DoubleJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Float
    public static FloatCondition when(Float term) {
        return new FloatCondition(term);
    }

    public static FloatJoinCondition whenAnyOf(Float... terms) {
        return new FloatJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static FloatJoinCondition whenAllOf(Float... terms) {
        return new FloatJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static FloatJoinCondition whenNoneOf(Float... terms) {
        return new FloatJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Short
    public static ShortCondition when(Short term) {
        return new ShortCondition(term);
    }

    public static ShortJoinCondition whenAnyOf(Short... terms) {
        return new ShortJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static ShortJoinCondition whenAllOf(Short... terms) {
        return new ShortJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static ShortJoinCondition whenNoneOf(Short... terms) {
        return new ShortJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Byte
    public static ByteCondition when(Byte term) {
        return new ByteCondition(term);
    }

    public static ByteJoinCondition whenAnyOf(Byte... terms) {
        return new ByteJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static ByteJoinCondition whenAllOf(Byte... terms) {
        return new ByteJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static ByteJoinCondition whenNoneOf(Byte... terms) {
        return new ByteJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Long
    public static LongCondition when(Long term) {
        return new LongCondition(term);
    }

    public static LongJoinCondition whenAnyOf(Long... terms) {
        return new LongJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static LongJoinCondition whenAllOf(Long... terms) {
        return new LongJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static LongJoinCondition whenNoneOf(Long... terms) {
        return new LongJoinCondition(JoinEnum.NONEOF, terms);
    }

    //Character
    public static CharacterCondition when(Character term) {
        return new CharacterCondition(term);
    }

    public static CharacterJoinCondition whenAnyOf(Character... terms) {
        return new CharacterJoinCondition(JoinEnum.ANYOF, terms);
    }

    public static CharacterJoinCondition whenAllOf(Character... terms) {
        return new CharacterJoinCondition(JoinEnum.ALLOF, terms);
    }

    public static CharacterJoinCondition whenNoneOf(Character... terms) {
        return new CharacterJoinCondition(JoinEnum.NONEOF, terms);
    }

}
