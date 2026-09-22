import java.util.*;

/*
 * Day 4 - Next Permutation
 * LeetCode 31
 *
 * Problem:
 * Find the next lexicographically greater permutation of the given array.
 * If no greater permutation exists, rearrange the array into the lowest
 * possible order.
 *
 * Example:
 * Input:  [1,2,3]
 * Output: [1,3,2]
 *
 * Approach:
 * 1. Find the first index from the right where nums[i] < nums[i + 1].
 * 2. Find an element from the right that is greater than nums[index].
 * 3. Swap these two elements.
 * 4. Reverse the portion after index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        int n = nums.length;
        int index = -1;

        // Step 1: Find the pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If no pivot, array is in descending order
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find element greater than nums[index]
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {

                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;

                break;
            }
        }

        // Step 3: Reverse the right portion
        reverse(nums, index + 1, n - 1);
    }

    public static void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}