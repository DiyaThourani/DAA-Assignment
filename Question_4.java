
public class Question_4{
    static int[][] dp;

    static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];   // characters match
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // take best
            }
        }
        return dp[m][n];
    }

    // Traceback to find the actual subsequence
    static String traceback(String s1, String s2) {
        int i = s1.length(), j = s2.length();
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1)); // part of LCS
                i--; j--;
            } else if (dp[i-1][j] > dp[i][j-1])
                i--;
            else
                j--;
        }
        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        String s1 = "DIYA";
        String s2 = "ETAOINSHR";

        // Remove spaces, uppercase
        s1 = s1.replace(" ", "").toUpperCase();
        s2 = s2.toUpperCase();

        int length = lcs(s1, s2);
        String subsequence = traceback(s1, s2);

        System.out.println("String 1     : " + s1);
        System.out.println("String 2     : " + s2);
        System.out.println("\nLCS Length   : " + length);
        System.out.println("LCS          : " + subsequence);
    }
}
