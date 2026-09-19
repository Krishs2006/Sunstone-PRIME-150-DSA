

import java.util.*;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;

                count++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        moveZeroes(nums);

        System.out.println("Array after moving zeroes:");
        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}
