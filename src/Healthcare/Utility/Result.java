package Healthcare.Utility;

import java.util.Optional;

public class Result<V, E> {
    private final V value;
    private final E error;
    private final boolean isOk;


    private Result(V value, E error, boolean isOk) {
        this.value = value;
        this.error = error;
        this.isOk = isOk;
    }

    public static <V, E> Result<V, E> ok(V value) {
        return new Result<>(value, null, true);
    }

    public static <V, E> Result<V, E> err(E error) {
        return new Result<>(null, error, false);
    }

    public boolean isOk() {
        return isOk;
    }

    public boolean isErr() {
        return !isOk;
    }


    public V unwrap() {
        if (!isOk) throw new RuntimeException("Called unwrap on an Error Result");
        return value;
    }


    public E getError() {
        return error;
    }
}