package com.example.demo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
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
        SendMessage sendMessage = new SendMessage();
        Chat chat = message.getChat();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(chat.getUserName());
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
