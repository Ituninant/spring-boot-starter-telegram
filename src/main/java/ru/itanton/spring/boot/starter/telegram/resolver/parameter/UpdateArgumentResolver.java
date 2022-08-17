package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author itanton
 */
@Component
public class UpdateArgumentResolver extends TypedHandlerMethodArgumentResolver<Update> {
    @Override
    public Update getValue(Update update) {
        return update;
    }
}
