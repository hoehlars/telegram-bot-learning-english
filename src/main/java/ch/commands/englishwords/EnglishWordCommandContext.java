package ch.commands.englishwords;

import ch.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EnglishWordCommandContext implements Command {
    private String currentGermanWord;
    private String currentMessageFromUser;
    private String currentUser;
    private EnglishWordState state;


    public EnglishWordCommandContext() {
        state = new StartEnglishWordState(this);
        currentGermanWord = null;
    }

    @Override
    public void execute(Update update) {
        currentUser = update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName();
        currentMessageFromUser = update.getMessage().getText();
        state.doAction();
    }

    public void setCurrentGermanWord(String germanWord) {
        this.currentGermanWord = germanWord;
    }

    public String getCurrentGermanWord() {
        return currentGermanWord;
    }

    public void setState(EnglishWordState state){
        this.state = state;
        state.onEntry();
    }

    public EnglishWordState getState(){
        return state;
    }

    public String getCurrentMessageFromUser() {
        return currentMessageFromUser;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
