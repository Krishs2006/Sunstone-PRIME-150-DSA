import java.util.*;

public class GroupAnagrams {

    /*
     * Problem: Group Anagrams
     * LeetCode: 49
     *
     * Approach:
     * Sort characters of each string.
     * The sorted string is used as a common key
     * for all anagrams.
     *
     * Time Complexity: O(n * k log k)
     * Space Complexity: O(n * k)
     */

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }
}