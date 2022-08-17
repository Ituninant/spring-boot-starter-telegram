package ru.itanton.spring.boot.starter.telegram.resolver.result;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.HandlerMethod;
import ru.itanton.spring.boot.starter.telegram.TelegramUpdateUtils;

import java.io.Serializable;

/**
 * @author itanton
 */
@Component
public class StringResultResolver implements HandlerMethodResultResolver {
    @Override
    public boolean supportsResult(HandlerMethod method) {
        return CharSequence.class.isAssignableFrom(method.getReturnType());
    }

    @Override
    public BotApiMethod<? extends Serializable> mapHandlerMethodResult(Object result, Update update) {
        SendMessage.SendMessageBuilder builder = SendMessage.builder();
        builder.chatId(TelegramUpdateUtils.getChatIdStr(update));
        builder.text(result.toString());
        return builder.build();
    }

}
