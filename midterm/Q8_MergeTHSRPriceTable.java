import java.util.*;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] station = new String[n];
        int[][] price = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            station[i] = scanner.next();
            price[i][0] = scanner.nextInt(); 
            price[i][1] = scanner.nextInt(); 
        }

        System.out.printf("%-8s|%9s|%9s\n", "Station", "Standard", "Business");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8s|%9d|%9d\n", station[i], price[i][0], price[i][1]);
        }

        scanner.close();
    }
}
