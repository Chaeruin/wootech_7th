package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicateNickName(forms);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    static List<String> getDuplicateNickName(List<List<String>> forms) {
        Set<String> duplicateEmail = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i+1; j < forms.size(); j++) {
                checkAndPutNickName(i, j , forms, duplicateEmail);
            }
        }
        return new ArrayList<>(duplicateEmail);
    }

    static void checkAndPutNickName(int i , int j, List<List<String>> forms, Set<String> duplicateEmail) {
        if (isContainNickName(forms.get(i).get(1), forms.get(j).get(1)) || isContainNickName(forms.get(j).get(1), forms.get(i).get(1))) {
            duplicateEmail.add(forms.get(i).get(0));
            duplicateEmail.add(forms.get(j).get(0));
        }
    }

    static boolean isContainNickName(String nameOne, String nameTwo) {
        for (int i = 0; i < nameOne.length() - 1; i++) {
            for (int j = i + 2; j < nameOne.length(); j++) {
                if (nameTwo.contains(nameOne.substring(i , j))) { return true; }
            }
        }
        return false;
    }
}
