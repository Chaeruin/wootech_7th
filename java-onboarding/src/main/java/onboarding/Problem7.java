package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {
    static List<Map<String, String>> friendshipByUser;
    static List<Map<String, String>> friendshipByFriend;
    static List<String> Friends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendshipByUser = new ArrayList<>();
        friendshipByFriend = new ArrayList<>();
        Friends = new ArrayList<>();
        setFriendship(user, friends);
        List<String> answer = getFive(user, calcSum(visitors));
        return answer;
    }

    static void setFriendship(String user, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String firstFriend = friends.get(i).get(0);
            String secondFriend = friends.get(i).get(1);
            if (firstFriend.equals(user)) {
                Map<String, String> tmp = new HashMap<>();
                tmp.put(user, secondFriend);
                friendshipByUser.add(tmp);
                Friends.add(secondFriend);
            } else if (friends.get(i).get(1).equals(user)) {
                Map<String, String> tmp = new HashMap<>();
                tmp.put(user, firstFriend);
                friendshipByUser.add(tmp);
                tmp = new HashMap<>();
                tmp.put(firstFriend, user);
                friendshipByFriend.add(tmp);
                Friends.add(firstFriend);
            } else {
                Map<String, String> tmp = new HashMap<>();
                tmp.put(firstFriend, secondFriend);
                friendshipByFriend.add(tmp);
            }
        }
    }

    static Map<String, Integer> calcSum(List<String> visitors) {
        Map<String, Integer> calcSumFriends = new LinkedHashMap<>();

        for (Map<String, String> fBU: friendshipByUser) {
            for (Map<String, String> fBF: friendshipByFriend) {
                for(Entry<String, String> fU: fBU.entrySet()) {
                    for (Entry<String, String> fF: fBF.entrySet()) {
                        if (fU.getValue().equals(fF.getKey())) {
                            calcSumFriends.put(fF.getValue(), 10);
                        }
                    }
                }
            }
        }
        for (String v: visitors) {
            if (calcSumFriends.get(v) != null) {
                calcSumFriends.replace(v, calcSumFriends.get(v) + 1);
            } else {
                calcSumFriends.put(v, 1);
            }
        }
        return calcSumFriends;
    }

    static List<String> getFive(String user, Map<String, Integer> calcSumFriends) {
        List<String> result = new LinkedList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(calcSumFriends.entrySet());
        entryList.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int idx = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            boolean isFlag = true;
            for (String f : Friends) {
                if (entry.getKey().equals(f)) {
                    isFlag = false;
                    break;
                }
            }
            if (entry.getKey().equals(user)) continue;
            if (isFlag) result.add(entry.getKey());
            idx++;
            if (idx == 5) break;
        }
        return result;
    }
}
