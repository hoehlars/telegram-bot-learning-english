package commands.englishwords;

public class WrongEnglishWordState extends EnglishWordState{

    public WrongEnglishWordState(EnglishWordCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        messengerInstance.sendMessageToUser("Wrong! Try again!");
        context.setState(new ReceiveEnglishWordState(context));
    }
}
