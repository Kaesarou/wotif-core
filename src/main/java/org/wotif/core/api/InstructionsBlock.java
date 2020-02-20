package org.wotif.core.api;

import java.util.function.Function;

public class InstructionsBlock<T, R> {

    private Instructions<T, R> previousInstructions;

    public InstructionsBlock(Instructions<T, R> instructions) {
        this.previousInstructions = instructions;
    }

    private InstructionsBlock<T, R> instructionsBlock(Result<?> result, CallBack callback) {
        if (this.previousInstructions.result().result())
            return this;
        Instructions<T, R> newEvaluation = new Instructions<>(this.previousInstructions.term(), result, callback);
        return new InstructionsBlock<>(newEvaluation);
    }

    private InstructionsBlock<T, R> instructionsBlock(Result<?> result, Function<T, R> function) {
        if (this.previousInstructions.result().result())
            return this;
        Instructions<T, R> newEvaluation = new Instructions<>(this.previousInstructions.term(), result, function);
        return new InstructionsBlock<>(newEvaluation);
    }

    public InstructionsBlock<T, R> orElse(CallBack callback) {
        return instructionsBlock(new Result<>(this.previousInstructions.term(), true), callback);
    }

    public InstructionsBlock<T, R> orElse(Function<T, R> function) {
        return instructionsBlock(new Result<>(this.previousInstructions.term(), true), function);
    }

    public InstructionsBlock<T, R> orElse(Result<?> anotherResult, CallBack callback) {
        return instructionsBlock(anotherResult, callback);
    }

    public InstructionsBlock<T, R> orElse(Result<?> anotherResult, Function<T, R> function) {
        return instructionsBlock(anotherResult, function);
    }

    public R end() {
        if (this.previousInstructions.result().result())
            return this.previousInstructions.executeAction();
        return null;
    }

}
