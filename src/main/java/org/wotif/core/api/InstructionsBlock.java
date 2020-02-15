package org.wotif.core.api;

import java.util.function.Supplier;

public class InstructionsBlock<T, R> {

    private Instructions<T, R> previousInstructions;

    public InstructionsBlock(Instructions<T, R> instructions) {
        this.previousInstructions = instructions;
    }

    private InstructionsBlock<T, R> instructionsBlock(Result<?> result, CallBack callBack) {
        if (this.previousInstructions.result().value())
            return this;
        Instructions<T, R> newEvaluation = new Instructions<>(result, callBack);
        return new InstructionsBlock<>(newEvaluation);
    }

    private InstructionsBlock<T, R> instructionsBlock(Result<?> result, Supplier<R> supplier) {
        if (this.previousInstructions.result().value())
            return this;
        Instructions<T, R> newEvaluation = new Instructions<>(result, supplier);
        return new InstructionsBlock<>(newEvaluation);
    }

    public InstructionsBlock<T, R> orElse(CallBack callBack) {
        return instructionsBlock(new Result<>(this.previousInstructions.result().term(), true), callBack);
    }

    public InstructionsBlock<T, R> orElse(Supplier<R> supplier) {
        return instructionsBlock(new Result<>(this.previousInstructions.result().term(), true), supplier);
    }

    public InstructionsBlock<T, R> orElse(Result<?> anotherResult, CallBack callBack) {
        return instructionsBlock(anotherResult, callBack);
    }

    public InstructionsBlock<T, R> orElse(Result<?> anotherResult, Supplier<R> supplier) {
        return instructionsBlock(anotherResult, supplier);
    }

    public R end() {
        if (this.previousInstructions.result().value())
            return this.previousInstructions.executeAction();
        return null;
    }

}
