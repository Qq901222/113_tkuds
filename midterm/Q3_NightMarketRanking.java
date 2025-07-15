import java.util.*;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(scanner.nextLine());
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        for (int i = 0; i < Math.min(5, n); i++) {
            System.out.printf("%.1f\n", scores[i]);
        }

        scanner.close();
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：
 * 使用選擇排序，會兩層迴圈逐步找出最大值來排序。
 * 外層跑 n 次，內層最多也跑 n 次。
 * 所以整體時間是平方等級 O(n^2)。
 */

