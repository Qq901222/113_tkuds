import java.util.Scanner;

public class ArraySearcher {
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數值: ");
        int target = scanner.nextInt();

        int index = findElement(arr, target);
        if (index != -1) {
            System.out.println("找到 " + target + "，索引位置: " + index);
        } else {
            System.out.println(target + " 未找到，回傳 -1");
        }

        int count = countOccurrences(arr, target);
        System.out.println(target + " 出現次數: " + count);

        scanner.close();
    }
}

