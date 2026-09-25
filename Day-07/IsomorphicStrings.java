import java.util.*;

public class IsomorphicStrings {

    /*
     * Problem: Isomorphic Strings
     * LeetCode: 205
     *
     * Description:
     * Check whether two strings follow the same character mapping.
     *
     * Approach:
     * Use two arrays to store mapping in both directions.
     * This makes sure that one character cannot map to multiple
     * characters and two characters cannot map to the same character.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static boolean isIsomorphic(String s, String t) {

        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            // Check existing s -> t mapping
            if (mapST[a] != 0 && mapST[a] != b + 1) {
                return false;
            }

            // Check existing t -> s mapping
            if (mapTS[b] != 0 && mapTS[b] != a + 1) {
                return false;
            }

            // Store the mapping
            mapST[a] = b + 1;
            mapTS[b] = a + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isIsomorphic(s, t));

        sc.close();
    }
}