package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] moneyList = new int[]{50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        return calcMoney(money, moneyList);
    }

    static List<Integer> calcMoney(int money, int[] moneyList) {
        Map<Integer, Integer> answer = initMap(moneyList);
        int idx = 0;
        while (money > 0) {
            if (money - moneyList[idx] >= 0) {
                answer.replace(moneyList[idx], answer.get(moneyList[idx]) + 1);
                money -= moneyList[idx];
            } else {
                idx++;
            }
        }
        return new ArrayList<>(answer.values());
    }

    static Map<Integer, Integer> initMap (int[] moneyList) {
        Map<Integer, Integer> initMap = new LinkedHashMap<>();
        for (int money : moneyList) {
            initMap.put(money, 0);
        }
        return initMap;
    }
}
