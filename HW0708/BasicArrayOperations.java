public class BasicArrayOperations {
    public static void main(String[] args) {
        int[] arr = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};
        System.out.println(arr.length);
        arr[2] = 99;
        arr[arr.length - 1] = 100;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }
}
