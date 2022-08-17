package ru.itanton.spring.boot.starter.telegram.resolver.result;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.HandlerMethod;

import java.io.Serializable;

/**
 * @author itanton
 */
@Component
public class CommonResultResolver implements HandlerMethodResultResolver {
    @Override
    public boolean supportsResult(HandlerMethod method) {
        return BotApiMethod.class.isAssignableFrom(method.getReturnType()); //TODO конкретные, а потом этот
    }

    @Override
    public BotApiMethod<? extends Serializable> mapHandlerMethodResult(Object result, Update update) {
        return (BotApiMethod<? extends Serializable>) result;
    }
}
