package ru.itanton.spring.boot.starter.telegram.type;

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
@TelegramBot(type = TelegramBotType.LONG_POOLING)
public @interface TelegramLongPoolingBot {
}
