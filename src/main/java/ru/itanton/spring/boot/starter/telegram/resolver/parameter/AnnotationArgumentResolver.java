package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import ru.itanton.spring.boot.starter.telegram.HandlerMethodParameter;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author itanton
 */
public abstract class AnnotationArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(HandlerMethodParameter parameter) {
        return List.of(parameter.getAnnotations()).stream().map(Annotation::annotationType).anyMatch(at -> at.equals(getAnnotation()));
    }

    protected abstract Class<? extends Annotation> getAnnotation();

}
