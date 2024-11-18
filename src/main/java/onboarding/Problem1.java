package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static int sumOfPages(Integer pages) {
        int[] page = Stream.of(String.valueOf(pages).split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(page).sum();
    }

    static int multiOfPages(Integer pages) {
        int[] page = Stream.of(String.valueOf(pages).split("")).mapToInt(Integer::parseInt).toArray();
        int mul = 1;
        for (int p: page) {
            mul *= p;
        }
        return mul;
    }

    static int maxWho(List<Integer> pobi, List<Integer> crong) {
        int max_pobi = calcMax(pobi);
        int max_crong = calcMax(crong);

        if (max_pobi > max_crong) {
            return 1;
        } else if (max_pobi < max_crong) {
            return 2;
        } else {
            return 0;
        }
    }

    static int calcMax(List<Integer> who) {
        int max_who = Integer.MIN_VALUE;

        for (Integer w: who) {
            max_who = Math.max(max_who, sumOfPages(w));
            max_who = Math.max(max_who, multiOfPages(w));
        }

        return max_who;
    }
}