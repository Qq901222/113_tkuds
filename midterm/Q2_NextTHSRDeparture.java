import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] times = new int[n];
        String[] rawTimes = new String[n];

        for (int i = 0; i < n; i++) {
            rawTimes[i] = scanner.nextLine();
            times[i] = toMinutes(rawTimes[i]);
        }

        String queryTime = scanner.nextLine();
        int queryMinutes = toMinutes(queryTime);

        int left = 0, right = n - 1;
        int idx = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryMinutes) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(rawTimes[idx]);
        }

        scanner.close();
    }
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：
 * 把查詢時間轉成分鐘數後，透過二分搜尋找出下一班車。
 * 每次搜尋都把範圍砍半。
 * 所以這題的時間複雜度是對數級的 O(log n)。
 */

