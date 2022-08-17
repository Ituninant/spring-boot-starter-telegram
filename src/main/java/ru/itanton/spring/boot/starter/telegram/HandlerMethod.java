package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author itanton
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class HandlerMethod {

    Object bean;

    Method method;

    List<HandlerMethodParameter> parameters;

    @SneakyThrows
    public Object doInvoke(Object... args) {
        return method.invoke(bean, args);
    }

    public Class<?> getReturnType() {
        return method.getReturnType();
    }

}
