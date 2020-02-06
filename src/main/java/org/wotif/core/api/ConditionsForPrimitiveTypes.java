package org.wotif.core.api;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.booleans.BooleanCondition;
import org.wotif.core.api.condition.typed.booleans.BooleanJoinCondition;
import org.wotif.core.api.condition.typed.character.CharacterCondition;
import org.wotif.core.api.condition.typed.character.CharacterJoinCondition;
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

class ConditionsForPrimitiveTypes {

    //Boolean
    public static BooleanCondition checkIf(Boolean term) { return new BooleanCondition(term); }
    public static BooleanJoinCondition checkIfAnyOf(Boolean... terms) { return new BooleanJoinCondition(JoinEnum.ANYOF, terms); }
    public static BooleanJoinCondition checkIfAllOf(Boolean... terms) { return new BooleanJoinCondition(JoinEnum.ALLOF, terms); }
    public static BooleanJoinCondition checkIfNoneOf(Boolean... terms) { return new BooleanJoinCondition(JoinEnum.NONEOF, terms); }
    //Integer
    public static IntegerCondition checkIf(Integer term) { return new IntegerCondition(term); }
    public static IntegerJoinCondition checkIfAnyOf(Integer... terms) { return new IntegerJoinCondition(JoinEnum.ANYOF, terms); }
    public static IntegerJoinCondition checkIfAllOf(Integer... terms) { return new IntegerJoinCondition(JoinEnum.ALLOF, terms); }
    public static IntegerJoinCondition checkIfNoneOf(Integer... terms) { return new IntegerJoinCondition(JoinEnum.NONEOF, terms); }
    //Double
    public static DoubleCondition checkIf(Double term) { return new DoubleCondition(term); }
    public static DoubleJoinCondition checkIfAnyOf(Double... terms) { return new DoubleJoinCondition(JoinEnum.ANYOF, terms); }
    public static DoubleJoinCondition checkIfAllOf(Double... terms) { return new DoubleJoinCondition(JoinEnum.ALLOF, terms); }
    public static DoubleJoinCondition checkIfNoneOf(Double... terms) { return new DoubleJoinCondition(JoinEnum.NONEOF, terms); }
    //Float
    public static FloatCondition checkIf(Float term) { return new FloatCondition(term); }
    public static FloatJoinCondition checkIfAnyOf(Float... terms) { return new FloatJoinCondition(JoinEnum.ANYOF, terms); }
    public static FloatJoinCondition checkIfAllOf(Float... terms) { return new FloatJoinCondition(JoinEnum.ALLOF, terms); }
    public static FloatJoinCondition checkIfNoneOf(Float... terms) { return new FloatJoinCondition(JoinEnum.NONEOF, terms); }
    //Short
    public static ShortCondition checkIf(Short term) { return new ShortCondition(term); }
    public static ShortJoinCondition checkIfAnyOf(Short... terms) { return new ShortJoinCondition(JoinEnum.ANYOF, terms); }
    public static ShortJoinCondition checkIfAllOf(Short... terms) { return new ShortJoinCondition(JoinEnum.ALLOF, terms); }
    public static ShortJoinCondition checkIfNoneOf(Short... terms) { return new ShortJoinCondition(JoinEnum.NONEOF, terms); }
    //Byte
    public static ByteCondition checkIf(Byte term) { return new ByteCondition(term); }
    public static ByteJoinCondition checkIfAnyOf(Byte... terms) { return new ByteJoinCondition(JoinEnum.ANYOF, terms); }
    public static ByteJoinCondition checkIfAllOf(Byte... terms) { return new ByteJoinCondition(JoinEnum.ALLOF, terms); }
    public static ByteJoinCondition checkIfNoneOf(Byte... terms) { return new ByteJoinCondition(JoinEnum.NONEOF, terms); }
    //Long
    public static LongCondition checkIf(Long term) { return new LongCondition(term); }
    public static LongJoinCondition checkIfAnyOf(Long... terms) { return new LongJoinCondition(JoinEnum.ANYOF, terms); }
    public static LongJoinCondition checkIfAllOf(Long... terms) { return new LongJoinCondition(JoinEnum.ALLOF, terms); }
    public static LongJoinCondition checkIfNoneOf(Long... terms) { return new LongJoinCondition(JoinEnum.NONEOF, terms); }
    //Character
    public static CharacterCondition checkIf(Character term) { return new CharacterCondition(term); }
    public static CharacterJoinCondition checkIfAnyOf(Character... terms) { return new CharacterJoinCondition(JoinEnum.ANYOF, terms); }
    public static CharacterJoinCondition checkIfAllOf(Character... terms) { return new CharacterJoinCondition(JoinEnum.ALLOF, terms); }
    public static CharacterJoinCondition checkIfNoneOf(Character... terms) { return new CharacterJoinCondition(JoinEnum.NONEOF, terms); }

}
