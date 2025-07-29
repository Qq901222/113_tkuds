import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Pair ans = solve(a, 0, n - 1);
        System.out.println("SecondMax: " + ans.second);
        sc.close();
    }

    static class Pair {
        int max, second;
        Pair(int max, int second) { this.max = max; this.second = second; }
    }

    private static Pair solve(int[] a, int l, int r) {
        if (l == r) return new Pair(a[l], Integer.MIN_VALUE);
        int m = (l + r) >>> 1;
        Pair L = solve(a, l, m);
        Pair R = solve(a, m + 1, r);
        if (L.max >= R.max) {
            return new Pair(L.max, Math.max(L.second, R.max));
        } else {
            return new Pair(R.max, Math.max(R.second, L.max));
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 用遞迴分治，把陣列分段找出最大與次大值。
 * 每個元素只處理一次，每次合併只比對最大值與次大值。
 * 所以整體是線性時間複雜度。
 */

