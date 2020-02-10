package ch.commands.conditionals;

import ch.commands.englishwords.AskEnglishWordState;

import java.util.Set;

public class CorrectFirstWordConditionalState extends ConditionalState {
    public CorrectFirstWordConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        messengerInstance.sendMessageToUser("The first word was correct!");
        messengerInstance.sendMessageToUser("What is the second word?");
        context.setState(new ReceiveSecondAnswerWordConditionalState(context));
    }
}
