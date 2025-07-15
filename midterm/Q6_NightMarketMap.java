import java.util.*;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] map = new char[10][10];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(map[i], '#');
        }

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 10 && col >= 0 && col < 10) {
                map[row][col] = '*';
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
