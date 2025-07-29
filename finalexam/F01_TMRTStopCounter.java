import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> stops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stops.add(sc.next()); 
        }

        String start = sc.next();
        String end = sc.next();

        int idx1 = stops.indexOf(start);
        int idx2 = stops.indexOf(end);

        if (idx1 == -1 || idx2 == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(idx1 - idx2) + 1);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 把所有停靠站掃一次，找出起點與終點的位置。
 * 每次比對站名是固定時間操作。
 * 所以整體是線性的時間複雜度，跟站數 n 成正比。
 */
