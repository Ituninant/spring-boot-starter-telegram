package ru.itanton.spring.boot.starter.telegram.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author itanton
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@MethodMapping
public @interface CallbackMapping {
    @AliasFor(annotation = MethodMapping.class)
    String value() default "";

    @AliasFor(annotation = MethodMapping.class)
    String mapping() default "";
}
