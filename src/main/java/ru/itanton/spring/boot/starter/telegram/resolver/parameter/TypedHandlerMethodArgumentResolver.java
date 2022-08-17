package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import org.springframework.core.ResolvableType;
import ru.itanton.spring.boot.starter.telegram.HandlerMethodParameter;

import java.util.Objects;

/**
 * @author itanton
 */
public abstract class TypedHandlerMethodArgumentResolver<T> implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(HandlerMethodParameter parameter) {
        ResolvableType resolvableType = ResolvableType.forClass(this.getClass()).as(TypedHandlerMethodArgumentResolver.class);
        return Objects.equals(resolvableType.getGeneric(0).resolve(), parameter.getType());
    }

}
