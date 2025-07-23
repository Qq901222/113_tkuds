public class gcd {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);  // 遞迴呼叫
    }

    public static void main(String[] args) {
        int a = 40;
        int b = 18;
        System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b));
    }
}



