package ch.commands.conditionals;

public class ReceiveSecondAnswerWordConditionalState extends ConditionalState {
    private static final String SKIP_WORD = "skip";

    public ReceiveSecondAnswerWordConditionalState(ConditionalsCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {

    }

    @Override
    public void doAction() {
        String currentExercise = context.getCurrentConditionalExercise();
        String guessedSecondAnswer = context.getCurrentMessageFromUser();

        if (guessedSecondAnswer.equals(SKIP_WORD)) {
            context.setState(new SkipConditionalState(context));
        } else {
            if (conditionalTaskSingleton.validateSencondAnswer(guessedSecondAnswer, currentExercise)) {
                context.setState(new CorrectSecondWordConditionalState(context));
            } else {
                context.setState(new WrongSecondWordConditionalState(context));
            }
        }
    }
}
