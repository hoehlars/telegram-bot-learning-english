package commands.englishwords;

import java.util.Iterator;
import java.util.Set;

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

        // print other correct words if there are any
        String currentGermanWord = context.getCurrentGermanWord();
        Set<String> otherCorrectWords = dictionaryInstance.getCorrectEnglishWords(currentGermanWord);


        if(otherCorrectWords.size() > 1) {
            String formattedOtherCorrectWords = formatOtherCorrectWords(otherCorrectWords);
            messengerInstance.sendMessageToUser("The other correct solutions was/were: " + formattedOtherCorrectWords);
        }

        context.setState(new AskEnglishWordState(context));
    }

    private String formatOtherCorrectWords(Set<String> otherCorrectWords) {

        StringBuilder sb = new StringBuilder();
        Iterator<String> itr = otherCorrectWords.iterator();

        String correctlyGuessedWord = context.getCurrentMessageFromUser();


        while(itr.hasNext()) {
            String correctEnglishWord = itr.next();

            // dont want to include word the user guessed correctly
            if(!correctEnglishWord.equals(correctlyGuessedWord)) {
                sb.append(correctEnglishWord);

                if(itr.hasNext()) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

}
