package ch.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictionairyReader implements Reader<String, Set<String>> {
    private static final String SPLIT_BY_ARROW = "->";
    private static final String VOCABULARY_FILE = "englishwords/Masterlist.txt";

    @Override
    public Map<String, Set<String>> read() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(VOCABULARY_FILE).getFile());

        Map<String, Set<String>> dictionairy = null;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
             dictionairy = new HashMap<String, Set<String>>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(SPLIT_BY_ARROW);
                clearSpacesAndNewlines(lineSplit);
                String key = null;
                String value = null;
                try {
                    key = lineSplit[0];
                    value = lineSplit[1];
                } catch(ArrayIndexOutOfBoundsException e) {
                }
                putIntoMap(key, value, dictionairy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionairy;
    }

    private void putIntoMap(String key, String value, Map<String, Set<String>> dictionairy) {
        Set<String> set = null;
        if(dictionairy.get(key) == null) {
            set = new HashSet<String>();
        } else {
            set = dictionairy.get(key);
        }
        set.add(value);
        dictionairy.put(key, set);
    }

    private void clearSpacesAndNewlines(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim().replace("\n", "");
        }
    }
}
