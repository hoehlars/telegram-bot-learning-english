package commands.englishwords;


public class AskEnglishWordState extends EnglishWordState {

    public AskEnglishWordState(EnglishWordCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        String randomGermanWord = dictionaryInstance.getRandomGermanWord();
        context.setCurrentGermanWord(randomGermanWord);
        messengerInstance.sendMessageToUser(randomGermanWord);
        context.setState(new ReceiveEnglishWordState(context));
    }
}
