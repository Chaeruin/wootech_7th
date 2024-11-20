package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7Re {
    static Map<String, List<String>> friendshipByUser;
    static Map<String, List<String>> friendshipByFriend;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendshipByUser = new LinkedHashMap<>();
        friendshipByFriend = new LinkedHashMap<>();
        setFriendship(user, friends);
        List<String> answer = getFive(user, calcSum(visitors));
        return answer;
    }

    static void setFriendship(String user, List<List<String>> friends) {
        for (List<String> pair : friends) {
            String firstFriend = pair.get(0);
            String secondFriend = pair.get(1);

            if (firstFriend.equals(user)) {
                addFriendshipUser(user, secondFriend);
            } else if (secondFriend.equals(user)) {
                addFriendshipUser(user, firstFriend);
                addFriendshipFriend(firstFriend, user);
            } else {
                addFriendshipFriend(firstFriend, secondFriend);
            }
        }
    }

    static void addFriendshipUser(String user, String friend) {
        friendshipByUser
                .computeIfAbsent(user, k -> new ArrayList<>())
                .add(friend);
    }

    static void addFriendshipFriend(String user, String friend) {
        friendshipByFriend
                .computeIfAbsent(user, k -> new ArrayList<>())
                .add(friend);
    }

    static Map<String, Integer> calcSum(List<String> visitors) {
        Map<String, Integer> calcSumFriends = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> userEntry : friendshipByUser.entrySet()) {
            userEntry.getValue().forEach(userFriend -> {
                // 해당 친구가 friendshipByFriend에 있는지 확인
                if (friendshipByFriend.containsKey(userFriend)) {
                    // 일치하는 친구를 가져와서 10점 부여
                    friendshipByFriend.get(userFriend).forEach(friendOfFriend -> {
                        calcSumFriends.put(friendOfFriend, 10);
                    });
                }
            });
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
            for (String f : friendshipByUser.get(user)) {
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
