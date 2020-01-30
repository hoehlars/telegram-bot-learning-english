package commands.conditionals;

import bot.MessengerSingleton;
import commands.Command;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ConditionalsCommand implements Command {
    private ConditionalState state;


    public ConditionalsCommand() {
        state = new ConditionalStartState();
    }

    @Override
    public void execute(Update update) {
        String messageFromUser = update.getMessage().getText();
        state.doAction();
    }

    public void setState(ConditionalState state) {
        this.state = state;
    }

    public ConditionalState getState() {
        return state;
    }

}
