import java.util.*;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = new int[7];
        for (int i = 0; i < 7; i++) {
            data[i] = scanner.nextInt();
        }

        int left = 0, right = 6;
        while (left < right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
            right--;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(data[i]);
            if (i < 6) System.out.print(" ");
        }
        System.out.println();

        scanner.close();
    }
}

