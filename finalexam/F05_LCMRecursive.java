import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = findGCD(a, b);
        long lcm = (long) a * b / gcd;
        System.out.println("LCM: " + lcm);

        sc.close();
    }

    private static int findGCD(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return findGCD(a - b, b);
        } else {
            return findGCD(a, b - a);
        }
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：
 * 用輾轉相減法求最大公因數，每次遞迴會讓其中一個數變小。
 * 最多呼叫到 a 或 b 歸零為止，次數與最大值有關。
 * 所以時間複雜度與 a, b 之中較大的值成正比。
 */

