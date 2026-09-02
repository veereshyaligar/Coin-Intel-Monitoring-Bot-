package com.startup.myapp.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class MarketTelegramBot implements SpringLongPollingBot {

    @Value("${telegram.bot.token}")
    private String botToken;
    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return updates -> {

            for (Update update : updates) {

                if (update.hasMessage() && update.getMessage().hasText()) {

                    System.out.println(update.getMessage().getText());
                    System.out.println(update.getMessage().getChatId());
                    System.out.println(update.getMessage().getFrom().getFirstName());

                }
            }

        };
    }
}
