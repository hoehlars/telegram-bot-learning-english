package ch.commands.conditionals;

public class WrongFirstWordConditionalState extends ConditionalState {
    public WrongFirstWordConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
       messengerInstance.sendMessageToUser("The answer was wrong. Try again!");
        context.setState(new ReceiveFirstAnswerConditionalState(context));
    }
}
