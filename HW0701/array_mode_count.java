public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};
        int mode = arr[0];
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}
//巢狀迴圈:
//陣列裡每個數字都去數它出現幾次
//找出出現最多次的數字（眾數）
//印出每次比對與最後結果
//時間複雜度：O(n²)

//用 Map 可降到 O(n)，因為
//建立一個 Map（像是小筆記本），記錄「每個數字出現幾次」
//跑一次陣列，每看一個數字就在 Map 裡把它的次數 +1
//跑完後再找出次數最大的數字（眾數）