import java.util.*;

public class lcs {
  public static void main(String[] args) {
    String text1 = "abcde";
    String text2 = "ace";
    System.out.println(LongestCommonSubstring(text1, text2));
  }

  static int LongestCommonSubstring(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int[][] dp = new int[n][m];

    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    return lcscount(s1, s2, n - 1, m - 1, dp);
  }

  static int lcscount(String s1, String s2, int ind1, int ind2, int[][] dp) {
    if (ind1 < 0 || ind2 < 0) {
      return 0;
    }

    if (dp[ind1][ind2] != -1) {
      return dp[ind1][ind2];
    }

    if (s1.charAt(ind1) == s1.charAt(ind2)) {
      return dp[ind1][ind2] = 1 + lcscount(s1, s2, ind1 - 1, ind2 - 1, dp);
    }

    else {
      return dp[ind1][ind2] = Math.max(lcscount(s1, s2, ind1, ind2 - 1, dp), lcscount(s1, s2, ind1 - 1, ind2, dp));
    }

  }
}