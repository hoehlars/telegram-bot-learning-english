package ch.readers;

import ch.commands.answers.ConditionalsAnswer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConditionalsExerciseReader implements Reader<String, ConditionalsAnswer> {
    private static final String SPLIT_BY_ARROW = "->";
    private static final String SPLIT_BY_COMMA = ",";
    private static final String CONDITIONALS_FILE = "/conditionals/exercises.txt";

    @Override
    public Map<String, ConditionalsAnswer> read() {
        Map<String, ConditionalsAnswer> conditionals = null;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(CONDITIONALS_FILE)))) {
            conditionals = new HashMap<String, ConditionalsAnswer>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(SPLIT_BY_ARROW);
                clearSpacesAndNewlines(lineSplit);
                String exercise = lineSplit[0];
                String answer =  lineSplit[1];
                putIntoMap(exercise, answer, conditionals);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conditionals;
    }

    private void putIntoMap(String exercise, String answer, Map<String, ConditionalsAnswer> conditionals) {
        String[] answers = answer.split(SPLIT_BY_COMMA);
        clearSpacesAndNewlines(answers);
        String firstAnswer = answers[0];
        String secondAnswer = answers[1];
        ConditionalsAnswer conditionalAnswer = new ConditionalsAnswer(firstAnswer, secondAnswer);
        conditionals.put(exercise, conditionalAnswer);
    }

    private void clearSpacesAndNewlines(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim().replace("\n", "");
        }
    }
}
