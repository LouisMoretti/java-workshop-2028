package fr.epita.assistants.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyTask<RETURN_TYPE> implements Task<RETURN_TYPE> {
    
    /* FIXME */

    /* FIXME */

    public static <RETURN_TYPE> Task<RETURN_TYPE> of(Supplier<RETURN_TYPE> actionSupplier) {
        throw new UnsupportedOperationException("FIXME");
    }

    @Override
    public CompletableFuture<RETURN_TYPE> build() {
        throw new UnsupportedOperationException("FIXME");
    }

    @Override
    public Task<RETURN_TYPE> onErrorRecoverWith(Function<Throwable, RETURN_TYPE> recoveryFunction) {
        throw new UnsupportedOperationException("FIXME");
    }

    @Override
    public <NEW_RETURN_TYPE> Task<NEW_RETURN_TYPE> andThenDo(Function<RETURN_TYPE, NEW_RETURN_TYPE> action) {
        throw new UnsupportedOperationException("FIXME");
    }

    @Override
    public Task<RETURN_TYPE> andThenWait(long number, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("FIXME");
    }
}
