package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import ru.itanton.spring.boot.starter.telegram.annotations.MethodMapping;
import ru.itanton.spring.boot.starter.telegram.annotations.TelegramBotHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author itanton
 */
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Getter
public class BotHandlerMethodRegistryBeanPostProcessor implements BeanPostProcessor {

    HandlerMethodsRegistry handlerMethodsRegistry;

    @Override
    public Object postProcessBeforeInitialization(Object bean, @NonNull String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(TelegramBotHandler.class)) {
            Arrays.stream(bean.getClass().getDeclaredMethods())
                    .filter(m -> AnnotatedElementUtils.hasMetaAnnotationTypes(m, MethodMapping.class))
                    .forEach(m -> handlerMethodsRegistry.register(getMapping(m), bean, m));
        }
        return bean;
    }

    private String getMapping(Method method) {
        MethodMapping annotation = AnnotatedElementUtils.findMergedAnnotation(method, MethodMapping.class);
        assert annotation != null;
        return annotation.mapping();
    }
}
