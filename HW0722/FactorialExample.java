public class FactorialExample {

    public static int factorialWithSteps(int n) {
        if (n < 0) {
            System.out.println("負數沒有階乘定義");
            return -1;
        }
        if (n == 0 || n == 1) {
            System.out.println(n + "! = 1 = 1");
            return 1;
        }

        int result = 1;
        System.out.print(n + "! = ");
        for (int i = n; i >= 1; i--) {
            System.out.print(i);
            result *= i;
            if (i != 1) {
                System.out.print(" * ");
            }
        }
        System.out.println(" = " + result);
        return result;
    }

    public static void main(String[] args) {
        factorialWithSteps(3); // 3! = 3 * 2 * 1 = 6
        factorialWithSteps(5); // 5! = 5 * 4 * 3 * 2 * 1 = 120
        factorialWithSteps(0); // 0! = 1 = 1
    }
}
