
import java.util.*;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Check if 1 is present
        boolean onePresent = false;

        for (int num : nums) {
            if (num == 1) {
                onePresent = true;
                break;
            }
        }

        if (!onePresent) {
            return 1;
        }

        // Replace useless values with 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Mark the numbers which are present
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            int index = value - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(firstMissingPositive(nums));

        sc.close();
    }
}