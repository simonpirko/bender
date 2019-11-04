package com.example.demo;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Processor {
    SendMessage getMessage(Update update);
}
