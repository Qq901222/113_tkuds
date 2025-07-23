import java.util.Scanner;

public class FactorialExampleinput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要計算階乘的整數: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("負數沒有階乘定義");
        } else {
            int result = 1;
            System.out.print(n + "! = ");

            if (n == 0 || n == 1) {
                System.out.println("1 = 1");
            } else {
                for (int i = n; i >= 1; i--) {
                    System.out.print(i);
                    result *= i;
                    if (i != 1) {
                        System.out.print(" * ");
                    }
                }
                System.out.println(" = " + result);
            }
        }

        sc.close();
    }
}

