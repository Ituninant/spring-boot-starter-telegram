package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.HandlerMethodParameter;

/**
 * @author itanton
 */
public interface HandlerMethodArgumentResolver {

    boolean supportsParameter(HandlerMethodParameter parameter);

    Object getValue(Update update);

}
