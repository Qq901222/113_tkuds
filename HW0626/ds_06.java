import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(50); 
        }

        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("陣列內容：");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n最大值為：" + max);
    }
}

