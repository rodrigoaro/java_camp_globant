package com.globant.javacodecamp.paths;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public record SuccessResult<T>(T value) implements Result<T> {

    @Override
    public <V> Result<V> map(Function<T, V> mapperFunction) {
        return new SuccessResult<>(mapperFunction.apply(value));
    }

    @Override
    public <V> Result<V> flatMap(Function<T, Result<V>> mapperFunction) {
        return mapperFunction.apply(value);
    }

    @Override
    public void ifSuccess(Consumer<T> action) {
        action.accept(value);
    }

    @Override
    public T orElse(Supplier<T> defaultValueSupplier) {
        return value;
    }

    @Override
    public void ifSuccessOrElse(Consumer<T> successAction, Consumer<ErrorResult.StatusAndMessage> errorAction) {
        successAction.accept(value);
    }
}
