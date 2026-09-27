import java.util.*;

public class StringToIntegerAtoi {

    public static int myAtoi(String s) {

        // Remove spaces from the beginning and end
        s = s.trim();

        int sign = 1;
        int i = 0;
        long res = 0;

        // If string becomes empty after removing spaces
        if (s.length() == 0) return 0;

        // Check whether the number is positive or negative
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } 
        else if (s.charAt(0) == '+') {
            i++;
        }

        // Read digits one by one and build the number
        while (i < s.length()) {

            char ch = s.charAt(i);

            // Stop as soon as a non-digit character is found
            if (ch < '0' || ch > '9') break;

            // Convert character digit into integer and add it to result
            res = res * 10 + (ch - '0');

            // Check if result goes outside the 32-bit integer range
            if (sign * res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign * res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        // Apply the sign and return the final number
        return (int) (sign * res);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(myAtoi(s));

        sc.close();
    }
}