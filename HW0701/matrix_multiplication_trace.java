public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = 0;
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                for (int k = 0; k < 2; k++) {
                    System.out.print(a[i][k] + "*" + b[k][j]);
                    c[i][j] += a[i][k] * b[k][j];
                    if (k != 1) {
                        System.out.print(" + ");
                    }
                }
                System.out.println(" = " + c[i][j]);
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            System.out.println(c[i][0] + " " + c[i][1]);
        }
    }
}
//外層兩層（i、j）負責決定每個結果矩陣位置（共 n^2 個）
//內層 k 負責進行加總乘積（每次計算需要 n 次）

//所以時間複雜度會是O(n^3)（n^2 個位置，每個位置做 n 次相乘加總）