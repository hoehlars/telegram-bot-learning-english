package ch.commands.conditionals;

public class StartConditionalState extends ConditionalState {

    public StartConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {

    }

    @Override
    public void doAction() {
        messengerInstance.sendMessageToUser("Welcome to the conditional exercises!");
        messengerInstance.sendMessageToUser("I'll give you an exercise about conditionals and you need to give me the correct missing words! Have fun!");
        messengerInstance.sendMessageToUser("If you want to skip an exercise type 'skip'.");
        messengerInstance.sendMessageToUser("Here is your first conditional exercise: ");
        context.setState(new AskConditionalState(context));

    }
}
