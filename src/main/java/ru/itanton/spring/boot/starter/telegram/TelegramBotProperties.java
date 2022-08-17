package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author itanton
 */
@ConfigurationProperties(prefix = "spring.telegram-bot")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter //TODO final
public class TelegramBotProperties {

    String username;

    String token;

    TelegramBotType type; //TODO

}
