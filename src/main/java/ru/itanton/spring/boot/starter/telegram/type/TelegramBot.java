package ru.itanton.spring.boot.starter.telegram.type;

import org.springframework.stereotype.Component;
import ru.itanton.spring.boot.starter.telegram.TelegramBotType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author itanton
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface TelegramBot {

    TelegramBotType type() default TelegramBotType.LONG_POOLING;

    String username() default "";

    String token() default "";

}
