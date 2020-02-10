package ch.commands;

import org.telegram.telegrambots.meta.api.objects.Update;


public interface Command {

    String ENGLISH_WORD_CMD = "/englishwords";
    String CONDITIONALS_CMD = "/conditionals";

    void execute(Update update);
}
