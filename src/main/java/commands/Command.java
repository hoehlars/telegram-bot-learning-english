package commands;

import org.telegram.telegrambots.meta.api.objects.Update;


public interface Command {

    String ENGLISH_WORD_CMD = "/englishwords";
    String EXIT_CMD = "/exit";

    void execute(Update update);
}
