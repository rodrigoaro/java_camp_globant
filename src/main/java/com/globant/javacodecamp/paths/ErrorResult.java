package com.globant.javacodecamp.paths;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public record ErrorResult<T>(int statusCode, String errorMessage) implements Result<T> {
    @Override
    public <V> Result<V> map(Function<T, V> mapperFunction) {
        return new ErrorResult<>(this.statusCode, this.errorMessage);
    }

    @Override
    public <V> Result<V> flatMap(Function<T, Result<V>> mapperFunction) {
        return new ErrorResult<>(this.statusCode, this.errorMessage);
    }

    @Override
    public void ifSuccess(Consumer<T> action) {
        // do nothing
    }

    @Override
    public T orElse(Supplier<T> defaultValueSupplier) {
        return defaultValueSupplier.get();
    }

    @Override
    public void ifSuccessOrElse(Consumer<T> successAction, Consumer<StatusAndMessage> errorAction) {
        errorAction.accept(new StatusAndMessage(statusCode, errorMessage));
    }

    public static record StatusAndMessage(int status, String message){

    }
}
