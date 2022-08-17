package ru.itanton.spring.boot.starter.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author itanton
 */
@Configuration
@ComponentScan
@EnableConfigurationProperties(TelegramBotProperties.class)
@Slf4j //TODO conditional
public class TelegramBotAutoConfiguration {

    @PostConstruct
    private void init() {
        log.debug("Init telegram starter");
    }

//    @Bean
//    public TelegramBot telegramBot(TelegramBotProperties properties, InvocationHandlerMethod invocationHandler) {
//        return new SpringTelegramBot(properties.getUsername(), properties.getUsername(), invocationHandler);
//    }

}
