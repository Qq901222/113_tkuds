import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine()); 
        List<Integer> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            times.add(toMinutes(time));
        }

        String queryTime = sc.nextLine();
        int queryMinutes = toMinutes(queryTime);

        int left = 0, right = n - 1;
        int answerIdx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times.get(mid) > queryMinutes) {
                answerIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (answerIdx == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(toHHmm(times.get(answerIdx)));
        }

        sc.close();
    }

    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static String toHHmm(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：
 * 回補時間是排序好的，用二分搜尋找第一個大於查詢時間的時刻。
 * 每次比較後能把搜尋區間砍半，因此時間複雜度是對數等級。
 */


