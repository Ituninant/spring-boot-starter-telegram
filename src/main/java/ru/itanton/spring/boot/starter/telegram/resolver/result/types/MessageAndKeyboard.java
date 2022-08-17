package ru.itanton.spring.boot.starter.telegram.resolver.result.types;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

/**
 * @author itanton
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Builder
@Getter
public class MessageAndKeyboard {

    String message;

    ReplyKeyboard keyboard;

}
