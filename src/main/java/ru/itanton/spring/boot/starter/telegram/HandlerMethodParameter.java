package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.lang.annotation.Annotation;

/**
 * @author itanton
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class HandlerMethodParameter {

    Annotation[] annotations;

    Class<?> type;

    String name;

    int index;

}
