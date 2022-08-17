package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

/**
 * @author itanton
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpringTelegramBot extends TelegramLongPollingBot {

    String username;
    String token;
    InvocationHandlerMethod invocationHandlerMethod;

    public SpringTelegramBot(TelegramBotProperties properties, InvocationHandlerMethod invocationHandlerMethod) {
        this.username = properties.getUsername();
        this.token = properties.getToken();
        this.invocationHandlerMethod = invocationHandlerMethod;
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        BotApiMethod<? extends Serializable> handle = invocationHandlerMethod.handle(update);
        if (handle != null) {
            execute(handle);
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
