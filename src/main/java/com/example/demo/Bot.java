package com.example.demo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    private final PropertyProvider propertyProvider;

    public Bot(PropertyProvider propertyProvider) {
        this.propertyProvider = propertyProvider;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            sendMsg(update, "Лена: Привет " + update.getMessage().getFrom().getFirstName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendMsg(update, "Аня: Как дела, любимый?");
        }
    }

    private void sendMsg(Update update, String text) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return propertyProvider.getName();
    }

    @Override
    public String getBotToken() {
        return propertyProvider.getToken();
    }
}
