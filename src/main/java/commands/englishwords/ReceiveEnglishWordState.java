package commands.englishwords;

public class ReceiveEnglishWordState extends EnglishWordState {
    public static final String SKIP_WORD = "skip word";


    public ReceiveEnglishWordState(EnglishWordCommandContext context) {
        super(context);
    }


    @Override
    public void onEntry() {

    }

    @Override
    public void doAction() {
        String currentGermanWord = context.getCurrentGermanWord();
        String guessedEnglishWord = context.getCurrentMessageFromUser();

        if (guessedEnglishWord.equals(SKIP_WORD)) {
            context.setState(new SkipWordEnglishWordState(context));

            // used if a word in the word list is english (should be german!)
        } else {
            if (dictionaryInstance.validateWord(guessedEnglishWord, currentGermanWord)) {
                context.setState(new CorrectEnglishWordState(context));
            } else {
                context.setState(new WrongEnglishWordState(context));
            }
        }
    }
}
