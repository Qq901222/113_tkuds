public class ArrayStatistics {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        int maxIndex = 0;
        int minIndex = 0;
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        double average = (double) sum / arr.length;
        int countAboveAverage = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                countAboveAverage++;
            }
        }

        System.out.println("=======================================");
        System.out.println("|         陣列統計分析結果表         |");
        System.out.println("=======================================");
        System.out.printf("| %-15s | %-15s |\n", "項目", "結果");
        System.out.println("---------------------------------------");
        System.out.printf("| %-15s | %-15d |\n", "總和", sum);
        System.out.printf("| %-15s | %-15.2f |\n", "平均值", average);
        System.out.printf("| %-15s | %-15d |\n", "最大值", max);
        System.out.printf("| %-15s | %-15d |\n", "最大值索引", maxIndex);
        System.out.printf("| %-15s | %-15d |\n", "最小值", min);
        System.out.printf("| %-15s | %-15d |\n", "最小值索引", minIndex);
        System.out.printf("| %-15s | %-15d |\n", "大於平均數量", countAboveAverage);
        System.out.printf("| %-15s | %-15d |\n", "偶數數量", evenCount);
        System.out.printf("| %-15s | %-15d |\n", "奇數數量", oddCount);
        System.out.println("=======================================");
    }
}
