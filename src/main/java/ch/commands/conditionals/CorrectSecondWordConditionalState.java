package ch.commands.conditionals;

public class CorrectSecondWordConditionalState extends ConditionalState {

    public CorrectSecondWordConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        messengerInstance.sendMessageToUser("Second word also correct!");
        messengerInstance.sendMessageToUser("Below you'll find a new exercise!");
        context.setState(new AskConditionalState(context));
    }
}
