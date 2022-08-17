package ru.itanton.spring.boot.starter.telegram.resolver.result;

import org.springframework.lang.Nullable;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.HandlerMethod;

import java.io.Serializable;

/**
 * @author itanton
 */
public interface HandlerMethodResultResolver {

    boolean supportsResult(HandlerMethod method);

    @Nullable
    BotApiMethod<? extends Serializable> mapHandlerMethodResult(Object result, Update update);

}
