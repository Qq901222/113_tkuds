import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); 
        String[] stops = scanner.nextLine().split(" "); 
        String[] query = scanner.nextLine().split(" "); 

        String start = query[0];
        String end = query[1];

        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIdx = i;
            }
            if (stops[i].equals(end)) {
                endIdx = i;
            }
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }

        scanner.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 把所有停靠站掃一次，找出起點與終點的位置。
 * 每次比對站名是固定時間操作。
 * 所以整體是線性的時間複雜度，跟站數 n 成正比。
 */
