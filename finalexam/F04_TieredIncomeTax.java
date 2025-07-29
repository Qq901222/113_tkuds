import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        double[] taxes = new double[n];
        double totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = sc.nextInt();
            double tax = calculateTax(income);
            taxes[i] = tax;
            totalTax += tax;
        }

        for (double tax : taxes) {
            System.out.printf("Tax: $%.0f%n", tax);
        }

        double averageTax = totalTax / n;
        System.out.printf("Average: $%.2f%n", averageTax);
    }

    public static double calculateTax(int income) {
        double tax = 0;
        int[] brackets = {0, 560000, 1260000, 2520000, 4720000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        int[] diffs = {560000, 700000, 1260000, 2200000}; 

        if (income <= brackets[1]) {
            tax = income * rates[0];
        } else if (income <= brackets[2]) {
            tax = (income - brackets[1]) * rates[1] + diffs[0] * rates[0];
        } else if (income <= brackets[3]) {
            tax = (income - brackets[2]) * rates[2] + diffs[1] * rates[1] + diffs[0] * rates[0];
        } else if (income <= brackets[4]) {
            tax = (income - brackets[3]) * rates[3] + diffs[2] * rates[2] + diffs[1] * rates[1] + diffs[0] * rates[0];
        } else {
            tax = (income - brackets[4]) * rates[4] + 
                  (4720000 - 2520000) * rates[3] + 
                  (2520000 - 1260000) * rates[2] + 
                  (1260000 - 560000) * rates[1] + 
                  (560000) * rates[0];
        }

        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 對每筆收入做一次稅額計算。
 * 每筆稅額都是固定步驟的區間判斷與簡單運算。
 * 所以整體跟收入筆數 n 成正比，是線性時間。
 */
