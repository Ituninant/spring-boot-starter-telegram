package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.resolver.parameter.annotations.MessageText;

import java.lang.annotation.Annotation;

/**
 * @author itanton
 */
@Component
public class MessageTextArgumentResolver extends AnnotationArgumentResolver {
    @Override
    public String getValue(Update update) {
        return update.getMessage().getText();
    }

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return MessageText.class;
    }
}
