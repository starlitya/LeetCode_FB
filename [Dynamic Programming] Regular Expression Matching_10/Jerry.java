class Solution {
   public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int M = s.length();
        int N = p.length();
        boolean[][] dp = new boolean[M+1][N+1]; // Text * Pattern

        /* dp[i][j] =
        case1: [j] = . or [i] == [j]
        case2: [j] = '*' ,
            check 都不用char dp[i][j-2]
            check2 if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
        case3: false
        */
        dp[0][0] = true;

        for (int j=2; j<=N; j++) {
            // check for j-2 position
            if (p.charAt(j-1) == '*' && dp[0][j-2]) {
                dp[0][j] = true;
            }
        }

        for (int i=1; i<=M; i++) {
            for (int j=1; j<=N; j++) {
                if (p.charAt(j-1) == '.' || p.charAt(j-1)==s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    if (j>1) {
                        // check for j-2 position
                        dp[i][j] |= dp[i][j-2];

                        // check for j-1 position or check or i-1
                        if (p.charAt(j-2) == '.' || p.charAt(j-2)==s.charAt(i-1)) {
                            dp[i][j] |= dp[i-1][j] || dp[i][j-1];
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        //System.out.println(Arrays.deepToString(dp));
        return dp[M][N];
    }
}