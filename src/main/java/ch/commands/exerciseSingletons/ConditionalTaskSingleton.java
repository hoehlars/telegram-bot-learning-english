package ch.commands.exerciseSingletons;

import ch.commands.answers.ConditionalsAnswer;
import ch.readers.ConditionalsExerciseReader;
import ch.readers.Reader;

import java.util.Map;
import java.util.Random;

public class ConditionalTaskSingleton {
    private static ConditionalTaskSingleton instance = new ConditionalTaskSingleton();
    private Map<String, ConditionalsAnswer> conditionals;
    private Random random;
    private Reader<String, ConditionalsAnswer> reader;


    private ConditionalTaskSingleton() {
        random = new Random();
        reader = new ConditionalsExerciseReader();
        conditionals = reader.read();
    }

    public static ConditionalTaskSingleton getInstance() {
        return instance;
    }

    public String getRandomExercise() {
        int randomNumber = random.nextInt(conditionals.size());
        int i = 0;
        String randomConditionalsExercise = null;
        for (String exercise : conditionals.keySet()) {
            if (i == randomNumber) {
                randomConditionalsExercise = exercise;
            }
            i++;
        }
        return randomConditionalsExercise;
    }

    public boolean validateFirstAnswer(String guessedFirstAnswer, String currentConditionalExercise) {
        String correctFirstAnswer = conditionals.get(currentConditionalExercise).getFirstAnswer();
        return correctFirstAnswer.equals(guessedFirstAnswer);
    }

    public boolean validateSencondAnswer(String guessedSecondAnswer, String currentConditionalExercise) {
        String correctSecondAnswer = conditionals.get(currentConditionalExercise).getSecondAnswer();
        return correctSecondAnswer.equals(guessedSecondAnswer);
    }

    public String getCorrectAnswers(String currentConditionalExercise) {
        ConditionalsAnswer conditionalsAnswer = conditionals.get(currentConditionalExercise);
        return "first word: " + conditionalsAnswer.getFirstAnswer() + ", second word: " + conditionalsAnswer.getSecondAnswer();
    }


}
