class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int [] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0'? 1: 0;

        // decode length as 2
        for (int i=2; i<=s.length(); i++) {
            // possible way + (i-2)
            if (Integer.parseInt(s.substring(i-2, i)) >= 10 && Integer.parseInt(s.substring(i-2, i)) <= 26) {
                dp[i] += dp[i-2];
            }

            // possible way + (i-1)
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
        }

        return dp[s.length()];
    }
}