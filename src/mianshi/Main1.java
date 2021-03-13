package mianshi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                map[i][j] = scanner.nextInt();
        }
        int[][] res = new int[m][n];
        int min = Math.min(n, m);
        for (int i = 0; i < min; i++) {
            for (int j = i; j < min; j++) {
                int temp = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = temp;
            }
        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < min; j++)
                res[i][j] = map[i][j];
        }
        if (n > m) {
            for (int i = 0; i < m; i++)
                res[i][n - 1] = map[n - 1][i];
        }
        else if (n < m) {
            for (int i = 0; i < n; i++)
                res[m - 1][i] = map[i][m - 1];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(res[i][j] + " ");
            System.out.println(" ");
        }
    }
}
