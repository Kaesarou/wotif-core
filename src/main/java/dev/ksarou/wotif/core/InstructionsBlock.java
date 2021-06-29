/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Class InstructionsBlock contains the instructions to execute
 * if the result value is true
 *
 * @author Cesare de Padua
 * Created on 26/02/2020
 */
public class InstructionsBlock<R> {

    private final Result<?> previousResult;

    private Instructions<R> previousInstructions;

    public InstructionsBlock(Result<?> result, Instructions<R> instructions) {
        this.previousResult = result;
        this.previousInstructions = instructions;
    }

    /**
     * If the result contained in the previous ins
     *
     * @param result   of type Result<?>
     * @param callback of type CallBack
     * @return InstructionsBlock<T, R>
     */
    private InstructionsBlock<R> instructionsBlock(Result<?> result, Runnable callback) {
        if (this.previousResult.result())
            return this;
        Instructions<R> newEvaluation = new Instructions<>(callback);
        return new InstructionsBlock<>(result, newEvaluation);
    }

    private InstructionsBlock<R> instructionsBlock(Result<?> result, Supplier<R> supplier) {
        if (this.previousResult.result())
            return this;
        Instructions<R> newEvaluation = new Instructions<>(supplier);
        return new InstructionsBlock<>(result, newEvaluation);
    }

    public InstructionsBlock<R> orElse(Runnable callback) {
        return instructionsBlock(Result.of(null, true), callback);
    }

    public InstructionsBlock<R> orElse(Supplier<R> supplier) {
        return instructionsBlock(Result.of(null, true), supplier);
    }

    public InstructionsBlock<R> orElse(Result<?> anotherResult, Runnable callback) {
        return instructionsBlock(anotherResult, callback);
    }

    public InstructionsBlock<R> orElse(Result<?> anotherResult, Supplier<R> supplier) {
        return instructionsBlock(anotherResult, supplier);
    }

    public R end() {
        if (this.previousResult.result())
            return this.previousInstructions.executeAction();
        return null;
    }

}
