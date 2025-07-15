import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();         
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = scanner.nextInt();   
        }
        int k = scanner.nextInt();            

        int[] ps = new int[n + 1];            
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + results[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();

        scanner.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 建立 prefix sum 陣列只要掃過一次原始比賽結果。
 * 每一項都只是簡單加法，花費固定時間。
 * 所以總體複雜度是 O(n)，效率很高。
 */

