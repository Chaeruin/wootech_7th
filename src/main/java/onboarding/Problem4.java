package onboarding;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<String, String> upperCase = mappingUpperCase();
        Map<String, String> lowerCase = mappingLowerCase();

        String answer = switchKeyToValue(word, upperCase, lowerCase);
        return answer;
    }

    static Map<String, String> mappingUpperCase() {
        Map<String, String> upperCase = new LinkedHashMap<>();
        // 대문자 맵핑
        int key = 90;
        int value = 65;
        for (int i = 0; i < 26; i++) {
            String Key = Character.toString((char)(key--));
            String Value = Character.toString((char)(value++));
            upperCase.put(Key, Value);
        }
        return upperCase;
    }

    static Map<String, String> mappingLowerCase() {
        Map<String, String> lowerCase = new LinkedHashMap<>();
        int key = 122;
        int value = 97;
        for (int i = 0; i < 26; i++) {
            String Key = Character.toString((char)(key--));
            String Value = Character.toString((char)(value++));
            lowerCase.put(Key, Value);
        }
        return lowerCase;
    }

    static String switchKeyToValue(String word, Map<String, String> upperCase, Map<String, String> lowerCase) {
        String[] wordCharAt = word.split("");
        for (int i = 0; i < wordCharAt.length; i++) {
            if (upperCase.containsKey(wordCharAt[i])) {
                wordCharAt[i] = upperCase.get(wordCharAt[i]);
            } else if (lowerCase.containsKey(wordCharAt[i])) {
                wordCharAt[i] = lowerCase.get(wordCharAt[i]);
            }
        }

        return String.join("", wordCharAt);
    }
}
