// matrix chain multipliction

import java.util.*;

public class mcm {
  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, 40, 50 };
    int n = arr.length;

    System.out.println(matrixMultiplication(arr, n));

  }

  static int matrixMultiplication(int[] arr, int n) {
    int[][] dp = new int[n][n];
    int i = 1;
    int j = n - 1;

    for (int[] row : dp)
      Arrays.fill(row, -1);

    return f(arr, i, j, dp);
  }

  static int f(int[] arr, int i, int j, int[][] dp) {
    if (i == j)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    int min = Integer.MAX_VALUE;

    for (int k = i; k <= j - 1; k++) {
      int count = f(arr, i, k, dp) + f(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
      min = Math.min(min, count);
    }

    return dp[i][j] = min;
  }
}