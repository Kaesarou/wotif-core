package dev.ksarou.wotif.core;

import java.util.function.Supplier;

public class InstructionsBlock<T, R> {

    private Instructions<T, R> previousInstructions;

    public InstructionsBlock(Instructions<T, R> instructions) {
        this.previousInstructions = instructions;
    }

    private InstructionsBlock<T, R> instructionsBlock(Result<?> result, CallBack callback) {
        if (this.previousInstructions.result().result())
            return this;
        Instructions<T, R> newEvaluation = new Instructions<>(result, callback);
        return new InstructionsBlock<>(newEvaluation);
    }

    private InstructionsBlock<T, R> instructionsBlock(Result<?> result, Supplier<R> supplier) {
        if (this.previousInstructions.result().result())
            return this;
        Instructions<T, R> newEvaluation = new Instructions<>(result, supplier);
        return new InstructionsBlock<>(newEvaluation);
    }

    public InstructionsBlock<T, R> orElse(CallBack callback) {
        return instructionsBlock(new Result<>(null, true), callback);
    }

    public InstructionsBlock<T, R> orElse(Supplier<R> supplier) {
        return instructionsBlock(new Result<>(null, true), supplier);
    }

    public InstructionsBlock<T, R> orElse(Result<?> anotherResult, CallBack callback) {
        return instructionsBlock(anotherResult, callback);
    }

    public InstructionsBlock<T, R> orElse(Result<?> anotherResult, Supplier<R> supplier) {
        return instructionsBlock(anotherResult, supplier);
    }

    public R end() {
        if (this.previousInstructions.result().result())
            return this.previousInstructions.executeAction();
        return null;
    }

}
