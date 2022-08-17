package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.resolver.parameter.HandlerMethodArgumentResolverComposite;
import ru.itanton.spring.boot.starter.telegram.resolver.result.HandlerMethodResultResolverComposite;

import java.io.Serializable;

/**
 * @author itanton
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class InvocationHandlerMethod {

    HandlerMethodsRegistry registry;
    HandlerMethodArgumentResolverComposite argumentResolverComposite;
    HandlerMethodResultResolverComposite resultResolverComposite;

    @Nullable
    public BotApiMethod<? extends Serializable> handle(Update update) {
        MappingRegistration registration = registry.getMapping(TelegramUpdateUtils.getText(update));
        if (registration == null) { //TODO
            //TODO
            throw new UnknownCommandException();
        }
        HandlerMethod handlerMethod = registration.getHandlerMethod();
        Object[] args = argumentResolverComposite.getArgValues(handlerMethod, update);
        Object result = handlerMethod.doInvoke(args);
        return resultResolverComposite.mapHandlerMethodResult(handlerMethod, result, update);
    }

}
