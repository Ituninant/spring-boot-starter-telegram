package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author itanton
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class MappingRegistration {

    String mapping;

    HandlerMethod handlerMethod;

}
