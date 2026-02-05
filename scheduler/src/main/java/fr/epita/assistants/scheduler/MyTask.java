package fr.epita.assistants.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyTask<RETURN_TYPE> implements Task<RETURN_TYPE> {

    CompletableFuture<RETURN_TYPE> myFuture;

    private MyTask(CompletableFuture<RETURN_TYPE> myFuture) {
        this.myFuture = myFuture;
    }

    public static <RETURN_TYPE> Task<RETURN_TYPE> of(Supplier<RETURN_TYPE> actionSupplier) {
        return new MyTask<>(CompletableFuture.supplyAsync(actionSupplier));
    }

    @Override
    public CompletableFuture<RETURN_TYPE> build() {
        return myFuture;
    }

    @Override
    public Task<RETURN_TYPE> onErrorRecoverWith(Function<Throwable, RETURN_TYPE> recoveryFunction) {
        return new MyTask<>(myFuture.exceptionally(recoveryFunction));
    }

    @Override
    public <NEW_RETURN_TYPE> Task<NEW_RETURN_TYPE> andThenDo(Function<RETURN_TYPE, NEW_RETURN_TYPE> action) {
        return new MyTask<>(myFuture.thenApply(action));
    }

    @Override
    public Task<RETURN_TYPE> andThenWait(long number, TimeUnit timeUnit) {
        return new MyTask<>(myFuture.thenApplyAsync(Function.identity(), CompletableFuture.delayedExecutor(number,
                timeUnit)));
    }
}
