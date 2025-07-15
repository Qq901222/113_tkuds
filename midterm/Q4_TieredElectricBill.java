import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] kWhList = new int[n];

        for (int i = 0; i < n; i++) {
            kWhList[i] = Integer.parseInt(scanner.nextLine());
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int bill = calc(kWhList[i]);
            System.out.println("Bill: $" + bill);
            total += bill;
        }

        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);

        scanner.close();
    }
    private static int calc(int kWh) {
        double total = 0;
        int[] limits =    {120, 210, 170, 200, 300, Integer.MAX_VALUE};
        double[] prices = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int remaining = kWh;

        for (int i = 0; i < limits.length; i++) {
            int used = Math.min(remaining, limits[i]);
            total += used * prices[i];
            remaining -= used;
            if (remaining <= 0) break;
        }

        return (int) Math.round(total); 
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 每一筆用電量都只需要計算一次，最多跑過 6 個費率區間。
 * 因為每筆費用計算花費固定時間。
 * 所以是線性複雜度，跟住戶數 n 成正比。
 */


