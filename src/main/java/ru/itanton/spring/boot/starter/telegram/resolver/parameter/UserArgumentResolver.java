package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

/**
 * @author itanton
 */
@Component
public class UserArgumentResolver extends TypedHandlerMethodArgumentResolver<User> {
    @Override
    public User getValue(Update update) {
        return update.getMessage().getFrom();
    }
}
