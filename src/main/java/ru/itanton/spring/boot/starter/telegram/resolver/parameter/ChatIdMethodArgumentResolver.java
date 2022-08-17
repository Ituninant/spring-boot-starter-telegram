package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.TelegramUpdateUtils;
import ru.itanton.spring.boot.starter.telegram.resolver.parameter.annotations.ChatId;

import java.lang.annotation.Annotation;

/**
 * @author itanton
 */
@Component
public class ChatIdMethodArgumentResolver extends AnnotationArgumentResolver {
//    @Override
//    public boolean supportsParameter(HandlerMethodParameter parameter) {
//        return List.of(parameter.getAnnotations()).contains(ChatId.class) ||
//                parameter.getType().equals(Long.class) && parameter.getName().equals("chatId");
//    }

    @Override
    public Long getValue(Update update) {
        return TelegramUpdateUtils.getChatId(update);
    }

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return ChatId.class;
    }
}
