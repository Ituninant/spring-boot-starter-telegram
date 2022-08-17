package ru.itanton.spring.boot.starter.telegram.resolver.result;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.HandlerMethod;
import ru.itanton.spring.boot.starter.telegram.TelegramUpdateUtils;
import ru.itanton.spring.boot.starter.telegram.resolver.result.types.MessageAndKeyboard;

import java.io.Serializable;

/**
 * @author itanton
 */
@Component
public class MessageAndKeyboardResultResolver implements HandlerMethodResultResolver {

    @Override
    public boolean supportsResult(HandlerMethod method) {
        return method.getReturnType().equals(MessageAndKeyboard.class);
    }

    @Override
    public BotApiMethod<? extends Serializable> mapHandlerMethodResult(Object result, Update update) {
        MessageAndKeyboard messageAndKeyboard = (MessageAndKeyboard) result;
        SendMessage.SendMessageBuilder builder = SendMessage.builder();
        builder.chatId(TelegramUpdateUtils.getChatIdStr(update));
        builder.replyMarkup(messageAndKeyboard.getKeyboard());
        builder.text(messageAndKeyboard.getMessage());
        return builder.build();
    }
}
