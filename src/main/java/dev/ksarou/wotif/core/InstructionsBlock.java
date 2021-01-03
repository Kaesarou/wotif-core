/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core;

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

    private final Instructions<R> previousInstructions;

    public InstructionsBlock(Result<?> result, Instructions<R> instructions) {
        this.previousResult = result;
        this.previousInstructions = instructions;
    }

    /**
     * If the result contained in the previous ins
     *
     * @param resultSupplier of type Result<?>
     * @param runnable       of type Runnable
     * @return InstructionsBlock<T, R>
     */
    private InstructionsBlock<R> instructionsBlock(Supplier<Result<?>> resultSupplier, Runnable runnable) {
        if (this.previousResult.result())
            return this;
        Instructions<R> newEvaluation = new Instructions<>(runnable);
        return new InstructionsBlock<>(resultSupplier.get(), newEvaluation);
    }

    private InstructionsBlock<R> instructionsBlock(Supplier<Result<?>> resultSupplier, Supplier<R> supplier) {
        if (this.previousResult.result())
            return this;
        Instructions<R> newEvaluation = new Instructions<>(supplier);
        return new InstructionsBlock<>(resultSupplier.get(), newEvaluation);
    }

    public InstructionsBlock<R> orElse(Runnable runnable) {
        return instructionsBlock(() -> Result.of(null, true), runnable);
    }

    public InstructionsBlock<R> orElse(Supplier<R> supplier) {
        return instructionsBlock(() -> Result.of(null, true), supplier);
    }

    public InstructionsBlock<R> orElse(Supplier<Result<?>> resultSupplier, Runnable runnable) {
        return instructionsBlock(resultSupplier, runnable);
    }

    public InstructionsBlock<R> orElse(Supplier<Result<?>> resultSupplier, Supplier<R> supplier) {
        return instructionsBlock(resultSupplier, supplier);
    }

    public R end() {
        if (this.previousResult.result())
            return this.previousInstructions.executeAction();
        return null;
    }

}
