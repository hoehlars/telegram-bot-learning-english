package ch.commands.conditionals;

import ch.commands.englishwords.CorrectEnglishWordState;
import ch.commands.englishwords.SkipWordEnglishWordState;
import ch.commands.englishwords.WrongEnglishWordState;

public class ReceiveFirstAnswerConditionalState extends ConditionalState {
    private static final String SKIP_WORD = "skip";


    public ReceiveFirstAnswerConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {

    }

    @Override
    public void doAction() {
        String currentExercise = context.getCurrentConditionalExercise();
        String guessedFirstAnswer = context.getCurrentMessageFromUser();

        if (guessedFirstAnswer.equals(SKIP_WORD)) {
            context.setState(new SkipConditionalState(context));
        } else {
            if (conditionalTaskSingleton.validateFirstAnswer(guessedFirstAnswer, currentExercise)) {
                context.setState(new CorrectFirstWordConditionalState(context));
            } else {
                context.setState(new WrongFirstWordConditionalState(context));
            }
        }
    }
}
