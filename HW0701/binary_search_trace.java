import java.util.Scanner;

public class binary_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int target = sc.nextInt();

        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("搜尋範圍：left = " + left + ", right = " + right + ", mid = " + mid + " → arr[mid] = " + arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("結果：已找到！");
        } else {
            System.out.println("結果：未找到！");
        }
    }
}
//與線性搜尋比較效率
//線性搜尋：O(n)（要從頭掃到尾）
//二元搜尋：O(log n)（每次搜尋會把範圍減半）
//資料量大且已排序的情況下，二元搜尋速度遠快於線性搜尋，是常用於快速查找的基礎演算法。
