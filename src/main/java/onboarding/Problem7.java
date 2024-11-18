package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {
    static Map<String, List<String>> friendshipByUser;
    static Map<String, List<String>> friendshipByFriend;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendshipByUser = new LinkedHashMap<>();
        friendshipByFriend = new LinkedHashMap<>();

        setFriendship(user, friends);
        System.out.println(friendshipByFriend);
        List<String> answer = getFive(calcSum(visitors));
        return answer;
    }

    static void setFriendship(String user, List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                userFriendList.add(friends.get(i).get(1));
                friendshipByUser.put(user, userFriendList);
            } else if (friends.get(i).get(1).equals(user)) {
                userFriendList.add(friends.get(i).get(0));
                friendshipByUser.put(user, userFriendList);
                friendshipByFriend.getOrDefault(friends.get(i).get(0), new ArrayList<>()).add(user);
            } else {
                friendshipByFriend.getOrDefault(friends.get(i).get(0), new ArrayList<>()).add(friends.get(i).get(1));
            }
        }
    }

    static Map<String, Integer> calcSum(List<String> visitors) {
        Map<String, Integer> calcSumFriends = new LinkedHashMap<>();
        for (Entry<String, List<String>> fBU: friendshipByUser.entrySet()) {
            for (String friends: fBU.getValue()) {
                calcSumFriends.put(friends, 10);
            }
        }

        for (Entry<String, List<String>> fBU: friendshipByFriend.entrySet()) {
            for (String friends: fBU.getValue()) {
                if (calcSumFriends.get(friends) != null) {
                    calcSumFriends.replace(friends, calcSumFriends.get(friends) + 1);
                } else {
                    calcSumFriends.put(friends, 1);
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

    static List<String> getFive(Map<String, Integer> calcSumFriends) {
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
            result.add(entry.getKey());
            idx++;
            if (idx == 5) break;
        }
        return result;
    }
}
