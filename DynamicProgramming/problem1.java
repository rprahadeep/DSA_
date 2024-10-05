// leetcode 516
// longest palindromic subsequence

import java.util.*;

public class problem1 {
  public static void main(String[] args) {

    String s1 = "cbbd";
    StringBuilder temp = new StringBuilder(s1);
    String s2 = temp.reverse().toString();
    System.out.println(lcs(s1, s2));
  }

  public static int lcs(String a, String b) {
    int n = a.length();
    int m = b.length();

    int dp[][] = new int[n][m];

    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    return lcscount(a, b, n - 1, m - 1, dp);
  }

  static int lcscount(String s1, String s2, int ind1, int ind2, int[][] dp) {
    if (ind1 < 0 || ind2 < 0) {
      return 0;
    }

    if (dp[ind1][ind2] != -1) {
      return dp[ind1][ind2];
    }

    if (s1.charAt(ind1) == s2.charAt(ind2)) {
      return dp[ind1][ind2] = 1 + lcscount(s1, s2, ind1 - 1, ind2 - 1, dp);
    }

    else {
      return dp[ind1][ind2] = Math.max(lcscount(s1, s2, ind1, ind2 - 1, dp), lcscount(s1, s2, ind1 - 1, ind2, dp));
    }

  }
}
