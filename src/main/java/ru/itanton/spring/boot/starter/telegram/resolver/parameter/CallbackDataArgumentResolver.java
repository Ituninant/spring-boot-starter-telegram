package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.resolver.parameter.annotations.CallbackData;

import java.lang.annotation.Annotation;

/**
 * @author itanton
 */
@Component
public class CallbackDataArgumentResolver extends AnnotationArgumentResolver {
    @Override
    public Object getValue(Update update) {
        return update.getCallbackQuery().getData();
    }

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return CallbackData.class;
    }
}
