package ch.commands.englishwords;

import ch.reader.DictionairyReader;
import ch.reader.Reader;

import java.util.Map;
import java.util.Random;
import java.util.Set;

public class DictionarySingleton {
    private static DictionarySingleton instance = new DictionarySingleton();
    private Map<String, Set<String>> vocabulary;
    private  Random random;
    private Reader<String, Set<String>> reader;

    private DictionarySingleton() {
        random = new Random();
        reader = new DictionairyReader();
        vocabulary = reader.read();
    }

    public static DictionarySingleton getInstance() {
        return instance;
    }

    public String getRandomGermanWord() {
        int randomNumber = random.nextInt(vocabulary.size());
        int i = 0;
        String randomGermanWord = null;
        for (String germanWord : vocabulary.keySet()) {
            if (i == randomNumber) {
                randomGermanWord = germanWord;
            }
            i++;
        }
        return randomGermanWord;
    }

    public boolean validateWord(String guessedEnglishWord, String germanWord) {
        Set<String> correctEnglishWords = vocabulary.get(germanWord);
        return correctEnglishWords.contains(guessedEnglishWord.toLowerCase());
    }

    public Set<String> getCorrectEnglishWords(String germanWord) {
        return vocabulary.get(germanWord);
    }


}
