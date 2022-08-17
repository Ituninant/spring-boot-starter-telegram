package ru.itanton.spring.boot.starter.telegram.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author itanton
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface MethodMapping {
    @AliasFor("mapping")
    String value() default "";

    @AliasFor("value")
    String mapping() default "";
}
