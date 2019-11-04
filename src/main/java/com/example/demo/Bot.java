package com.example.demo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    private final ProdPropertyProvider prodPropertyProvider;
    private final Processor processor;

    public Bot(ProdPropertyProvider prodPropertyProvider, Processor processor) {
        this.prodPropertyProvider = prodPropertyProvider;
        this.processor = processor;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            Thread.sleep(1000);
            execute(processor.getMessage(update));
        } catch (InterruptedException | TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println(update.getMessage().getFrom().getUserName() + " " + update.getMessage().getText());
    }


    @Override
    public String getBotUsername() {
        return prodPropertyProvider.getName();
    }

    @Override
    public String getBotToken() {
        return prodPropertyProvider.getToken();
    }
}
