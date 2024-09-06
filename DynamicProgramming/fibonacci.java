//fibonacci number using memoization

import java.util.*;

public class fibonacci {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(f(n, dp));
  }

  static int f(int n, int[] dp) {
    if (n <= 1)
      return n;
    if (dp[n] != -1)
      return dp[n];
    return dp[n] = f(n - 1, dp) + f(n - 2, dp);
  }

}
