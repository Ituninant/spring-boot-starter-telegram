package ru.itanton.spring.boot.starter.telegram;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author itanton
 */
@UtilityClass
public class TelegramUpdateUtils {

    public Long getChatId(Update update) {
        return update.getMessage() != null ? update.getMessage().getChatId() : update.getCallbackQuery().getMessage().getChatId();
    }

    public String getChatIdStr(Update update) {
        return String.valueOf(getChatId(update));
    }

    public String getText(Update update) {
        return update.getMessage() != null ? update.getMessage().getText() : update.getCallbackQuery().getData();
    }

}
