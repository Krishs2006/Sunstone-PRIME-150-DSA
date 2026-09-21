import java.util.*;

/*
 * Day 3 - Rotate Array
 * LeetCode 189
 *
 * Problem:
 * Given an integer array nums, rotate the array to the right by k steps.
 *
 * Example:
 * Input:  nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Approach:
 * Reversal Algorithm
 *
 * 1. Reverse the entire array.
 * 2. Reverse the first k elements.
 * 3. Reverse the remaining elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RotateArray {

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }
}