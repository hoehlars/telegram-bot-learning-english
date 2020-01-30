package commands.englishwords;

import java.util.Iterator;
import java.util.Set;

public class SkipWordEnglishWordState extends EnglishWordState {


    public SkipWordEnglishWordState(EnglishWordCommandContext context) {
        super(context);
    }

    @Override
    public void onEntry() {
        doAction();
    }

    @Override
    public void doAction() {
        String currentGermanWord = context.getCurrentGermanWord();
        String correctEnglishWordsFormatted = formatCorrectEnglishWords(currentGermanWord);
        messengerInstance.sendMessageToUser("The correct solution(-s) was/were: " + correctEnglishWordsFormatted);
        context.setState(new AskEnglishWordState(context));
    }

    private String formatCorrectEnglishWords(String currentGermanWord) {
        Set<String> correctEnglishWords = dictionaryInstance.getCorrectEnglishWords(currentGermanWord);
        StringBuilder sb = new StringBuilder();

        Iterator<String> itr = correctEnglishWords.iterator();

        for(int i = 0; itr.hasNext(); i++) {
            sb.append(itr.next());

            if(itr.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
