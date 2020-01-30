package commands.englishwords;

public class CorrectEnglishWordState extends EnglishWordState {


    public CorrectEnglishWordState(EnglishWordCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        messengerInstance.sendMessageToUser("Correct!");
        context.setState(new AskEnglishWordState(context));
    }

}
