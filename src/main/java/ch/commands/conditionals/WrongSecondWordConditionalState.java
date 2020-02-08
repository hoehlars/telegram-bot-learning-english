package ch.commands.conditionals;

public class WrongSecondWordConditionalState extends ConditionalState {
    public WrongSecondWordConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        messengerInstance.sendMessageToUser("The answer was wrong. Try again!");
        context.setState(new ReceiveSecondAnswerWordConditionalState(context));
    }
}
