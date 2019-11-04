package com.example.demo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bender extends TelegramLongPollingBot {

    private final PropertyProvider propertyProvider;

    public Bender(PropertyProvider propertyProvider) {
        this.propertyProvider = propertyProvider;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println(message.getText());
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
