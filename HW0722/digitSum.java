public class digitSum {
    public static int digitSum(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Digit sum of " + num + " is " + digitSum(num));  
    }
}

