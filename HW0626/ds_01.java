import java.util.Scanner;

public class ds_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("第一個整數：");
        int num1 = scanner.nextInt();

        System.out.print("第二個整數：");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        System.out.println("兩數和為：" + sum);
    }
}
