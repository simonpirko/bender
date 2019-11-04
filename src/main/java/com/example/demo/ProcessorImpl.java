package com.example.demo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ProcessorImpl implements Processor {

    private SendMessage sendMsg(Update update, String text) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        return sendMessage;
    }


    @Override
    public SendMessage getMessage(Update update) {
        String text = update.getMessage().getText();
        if (text.equals("/start")){
            return sendMsg(update, "Привет, как тебя зовут?");
        }
        if (text.equalsIgnoreCase("Привет")) {
            return sendMsg(update, "Привет " + update.getMessage().getFrom().getFirstName());
        } else if (text.equalsIgnoreCase("Как дела?")) {
            return sendMsg(update, "Хорошо, а у тебя как?");
        } else if (text.equalsIgnoreCase("Нормально")) {
            return sendMsg(update, "Понятно, чем занимаешься?");
        } else {
            return sendMsg(update, "Что такое " + text + "?");
        }
    }

    private String startMsg() {
        return "Привет:) Как твое имя?";
    }

    private String defaultQ(String msg) {
        return "Что такое " + msg + "?";
    }
}
