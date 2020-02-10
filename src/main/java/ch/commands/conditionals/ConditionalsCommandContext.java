package ch.commands.conditionals;

import ch.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ConditionalsCommandContext implements Command {
    private String currentConditionalExercise;
    private String currentMessageFromUser;
    private String currentUser;
    private ConditionalState state;


    public ConditionalsCommandContext() {
        state = new StartConditionalState(this);
        currentConditionalExercise = null;
    }

    @Override
    public void execute(Update update) {
        currentUser = update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName();
        currentMessageFromUser = update.getMessage().getText();
        state.doAction();
    }

    public void setCurrentConditionalExercise(String currentConditionalExercise) {
        this.currentConditionalExercise = currentConditionalExercise;
    }

    public String getCurrentConditionalExercise() {
        return currentConditionalExercise;
    }

    public void setState(ConditionalState state){
        this.state = state;
        state.onEntry();
    }

    public ConditionalState getState(){
        return state;
    }

    public String getCurrentMessageFromUser() {
        return currentMessageFromUser;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
