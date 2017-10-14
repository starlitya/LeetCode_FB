class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int M = matrix.length;
        int N = matrix[0].length;

        int max = 0;
        int [][] record = new int[M+1][N+1]; // for edge case
        for (int i=1; i<M+1; i++) {
            for (int j=1; j< N+1; j++) {
                 // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
                if (matrix[i-1][j-1] == '1') {
                    record[i][j] = Math.min(record[i-1][j], Math.min(record[i][j-1], record[i-1][j-1])) 
                        + 1;
                }

                max = Math.max(max , record[i][j]);
            }
        }

        //System.out.println("Print " + Arrays.deepToString(record));
        return max * max;
    }
}