package com.globant.javacodecamp.paths;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Result<T> {
    <V> Result<V> map(Function<T, V> mapperFunction);
    <V> Result<V> flatMap(Function<T, Result<V>> mapperFunction);
    void ifSuccess(Consumer<T> action);
    T orElse(Supplier<T> defaultValueSupplier);

    void ifSuccessOrElse(Consumer<T> successAction, Consumer<ErrorResult.StatusAndMessage> errorAction);

    static <T> Result<T> success(T value){
        return new SuccessResult<>(value);
    }

    static <T> Result<T> error(int statusCode, String message){
        return new ErrorResult<>(statusCode, message);
    }
}
