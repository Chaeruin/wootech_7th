package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {

    public static String solution(String cryptogram) {
        String[] crypt = cryptogram.split("");
        while (validateDuplicate(crypt)) {
            crypt = cryptogram.split("");
            crypt = eraseDuplicate(crypt);
            cryptogram = combineString(crypt);
        }
        return cryptogram;
    }

    static String[] eraseDuplicate(String[] crypt) {
        for (int i = 0; i < crypt.length - 1; i++) {
            if (crypt[i].equals(crypt[i+1])) {
                crypt[i] = "-";
                crypt[i+1] = "-";
            }
        }
        return crypt;
    }

    static String combineString(String[] crypt) {
        List<String> string = new LinkedList<>();
        for (String s : crypt) {
            if (!s.equals("-")) {
                string.add(s);
            }
        }
        return String.join("", string);
    }

    static boolean validateDuplicate(String[] crypt) {
        for (int i = 0; i < crypt.length - 1; i++) {
            if (crypt[i].equals(crypt[i+1])) {
                return true;
            }
        }
        return false;
    }
}
