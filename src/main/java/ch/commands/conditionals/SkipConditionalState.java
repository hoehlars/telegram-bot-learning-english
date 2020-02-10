package ch.commands.conditionals;

import ch.commands.englishwords.AskEnglishWordState;

public class SkipConditionalState extends ConditionalState {
    public SkipConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        String currentConditionalExercise = context.getCurrentConditionalExercise();
        String correctAnswers = conditionalTaskSingleton.getCorrectAnswers(currentConditionalExercise);
        messengerInstance.sendMessageToUser("The correct solution was : " + correctAnswers);
        context.setState(new AskConditionalState(context));
    }
}
