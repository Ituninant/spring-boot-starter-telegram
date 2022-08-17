package ru.itanton.spring.boot.starter.telegram.example;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.itanton.spring.boot.starter.telegram.annotations.CallbackMapping;
import ru.itanton.spring.boot.starter.telegram.annotations.MessageMapping;
import ru.itanton.spring.boot.starter.telegram.annotations.TelegramBotHandler;
import ru.itanton.spring.boot.starter.telegram.resolver.parameter.annotations.CallbackData;
import ru.itanton.spring.boot.starter.telegram.resolver.parameter.annotations.ChatId;
import ru.itanton.spring.boot.starter.telegram.resolver.parameter.annotations.MessageText;
import ru.itanton.spring.boot.starter.telegram.resolver.result.types.MessageAndKeyboard;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author itanton
 */
@TelegramBotHandler
@Slf4j
public class MyFirstBot {

    @PostConstruct
    private void inti() {
        log.debug("Init MyFirstBot");
    }

    @MessageMapping
    public void debug(Update update, @MessageText String messageText, @ChatId Long chatId, User user) {
        log.debug("update = " + update);
        log.debug("messageText = " + messageText);
        log.debug("chatId = " + chatId);
        log.debug("user = " + user);
    }

    @MessageMapping(mapping = "/start")
    public String start() {
        log.debug("start");
        return "Hello!";
    }

    @CallbackMapping("callback")
    public String callback(@CallbackData String callbackData) {
        log.debug(callbackData);
        return "ok callback";
    }

    @MessageMapping("/keyboard")
    public MessageAndKeyboard sendKeyboard() {
        ReplyKeyboard replyKeyboard = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder()
                                .text("test")
                                .callbackData("callback")
                                .build()
                ))
                .build();

//        ReplyKeyboard replyKeyboard = ReplyKeyboardMarkup.builder()
//                .keyboardRow(new KeyboardRow(
//                                List.of(KeyboardButton.builder().text("test").build())
//                        )
//                )
//                .build();

//        ReplyKeyboard replyKeyboard = ReplyKeyboardRemove.builder()
//                .removeKeyboard(true)
//                .build();

//        ReplyKeyboard replyKeyboard = ForceReplyKeyboard.builder()
//                .forceReply(true)
//                .selective(true)
//                .inputFieldPlaceholder("tets")
//                .build();

        return MessageAndKeyboard.builder()
                .keyboard(replyKeyboard)
                .message("ok")
                .build();
    }

}
