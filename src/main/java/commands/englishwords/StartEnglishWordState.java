package commands.englishwords;

public class StartEnglishWordState extends EnglishWordState {

    public StartEnglishWordState(EnglishWordCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {

    }

    public void doAction() {
        messengerInstance.sendMessageToUser("Welcome to the english vocabulary game!");
        messengerInstance.sendMessageToUser("I'll give you a german word and you need to give me the correct english translation! Have fun!");
        messengerInstance.sendMessageToUser("If you want to skip a word type 'skip word'.");
        messengerInstance.sendMessageToUser("Here is your first german word: ");
        context.setState(new AskEnglishWordState(context));
    }

}
