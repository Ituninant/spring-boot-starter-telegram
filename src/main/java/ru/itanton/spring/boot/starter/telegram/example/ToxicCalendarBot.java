//package ru.itanton.toxiccalendarbot.bot;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Message;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//
//import static org.telegram.telegrambots.meta.api.methods.send.SendMessage.SendMessageBuilder;
//
///**
// * @author itanton
// */
//@Component
//@Slf4j
//public class ToxicCalendarBot extends TelegramLongPollingBot {
//
//    private static final String WHAT_DO_WE_HAVE_COMMAND = "/Че там у нас";
//
//    private final String token;
//    private final String username;
//
//    private final Map<String, String> responsesMap;
//
//    public ToxicCalendarBot(@Value("${bot.token}") String token, @Value("${bot.username}") String username) {
//        this.token = token;
//        this.username = username;
//        this.responsesMap = new ConcurrentHashMap<>(getResponsesMap());
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//        if (!update.hasMessage()) {
//            log.debug("Message is empty");
//            return;
//        }
//
//        Message message = update.getMessage();
//        log.debug("Hi {} {} {}", message.getFrom().getFirstName(), message.getFrom().getLastName(), message.getFrom().getUserName());
//
//        SendMessageBuilder responseBuilder = SendMessage.builder();
//        responseBuilder.chatId(String.valueOf(message.getChatId()));
//        responseBuilder.replyMarkup(getKeyboard());
//
//        String responseText = responsesMap.get(message.getText());
//        Optional.ofNullable(responseText).ifPresent(rt -> sendResponse(responseBuilder, rt));
//    }
//
//    @Override
//    public String getBotToken() {
//        return token;
//    }
//
//    @Override
//    public String getBotUsername() {
//        return username;
//    }
//
//    private Map<String, String> getResponsesMap() {
//        String cakeEmoji = "\uD83C\uDF82";
//        String airplaneEmoji = "\uE01D";
//        return Map.of(
//                "/start", "Hello!",
//                WHAT_DO_WE_HAVE_COMMAND, cakeEmoji + " 20-22.05.2022 ДР Катя Мишина, аквадискотека \n" +
//                        cakeEmoji + " 03-05.06.2022 ДР Саша Итунина, единороги и блестки \n" +
//                        airplaneEmoji + " 11-13.06.2022 Рыбинск \n" +
//                        airplaneEmoji + " 31.07.2022-07.08.2022 Пятигорск"
//        );
//    }
//
//    private ReplyKeyboard getKeyboard() {
//        KeyboardRow keyboardRow = new KeyboardRow();
//        keyboardRow.add(WHAT_DO_WE_HAVE_COMMAND);
//        List<KeyboardRow> keyboardRows = List.of(keyboardRow);
//
//        ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();
//        replyKeyboard.setKeyboard(keyboardRows);
//        return replyKeyboard;
//    }
//
//    private void sendResponse(SendMessageBuilder responseBuilder, String responseText) {
//        responseBuilder.text(responseText);
//        try {
//            execute(responseBuilder.build());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//}
