import java.util.*;

public class RomanToInteger {

    /*
     * Problem: Roman to Integer
     * LeetCode: 13
     *
     * Description:
     * Convert a Roman numeral string into its integer value.
     *
     * Approach:
     * Traverse the string from right to left.
     * If the current value is part of a subtractive pair, subtract it.
     * Otherwise, add it to the answer.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int romanToInt(String s) {
        int ans = 0;
        int num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }

            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(romanToInt(s));

        sc.close();
    }
}