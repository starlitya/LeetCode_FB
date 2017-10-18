class Solution {
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int count = 0;
        int M = grid.length;
        int N = grid[0].length;
        
        // Can assgin grid[i][j] to zero to instead of
        boolean isVisited [][] = new boolean[M][N];
        for (int i=0; i < M; i++) {
            for (int j=0; j < N; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    helper(grid, isVisited, i, j);                    
                    count++;
                }
            }
        }
        return count;
    }
    
    private void helper(char[][] grid, boolean[][] isVisited, int startX, int startY) {
        if (startX < 0 || startY < 0 || startX >= grid.length || startY >= grid[0].length) {
            return;
        }
        
        if (grid[startX][startY] == '0' || isVisited[startX][startY]) {
            return;
        }
        
        isVisited[startX][startY] = true;
        
        helper(grid, isVisited, startX, startY-1);
        helper(grid, isVisited, startX, startY+1);
        helper(grid, isVisited, startX-1, startY);
        helper(grid, isVisited, startX+1, startY);
    }
    
}