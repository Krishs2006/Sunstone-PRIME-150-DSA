import java.util.*;

public class FirstMissingPositive_Sorting {

    public static int firstMissingPositive(int[] arr) {
        int num = 1;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                num++;
            }

            if (arr[i] > num) {
                break;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(firstMissingPositive(arr));

        sc.close();
    }
}