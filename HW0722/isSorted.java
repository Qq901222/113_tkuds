public class isSorted {
    public static boolean isSorted(int[] arr, int index) {
        // 終止條件：如果已檢查到最後一對
        if (index >= arr.length - 1) {
            return true;
        }

        // 若當前元素大於下一個，則不是升序
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 遞迴檢查下一對
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 5};

        System.out.println("arr1 is sorted: " + isSorted(arr1, 0));  // true
        System.out.println("arr2 is sorted: " + isSorted(arr2, 0));  // false
    }
}
