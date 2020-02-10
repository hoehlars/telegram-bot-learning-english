package ch.commands.conditionals;

public class AskConditionalState extends ConditionalState {
    public AskConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        String randomConditionalExercise = conditionalTaskSingleton.getRandomExercise();
        context.setCurrentConditionalExercise(randomConditionalExercise);
        messengerInstance.sendMessageToUser(randomConditionalExercise);
        messengerInstance.sendMessageToUser("What is the first word?");
        context.setState(new ReceiveFirstAnswerConditionalState(context));
    }
}
