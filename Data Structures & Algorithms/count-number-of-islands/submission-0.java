class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int cnt = 0;
        for(int i=0;i<rows;i++){
            for(int j = 0; j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j, rows, cols);
                    cnt+=1;
                }
            }
        }
        return cnt;   
    }
    private void dfs(char[][] grid, int i, int j, int rows, int cols){
        int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if(i<0||i>=rows||j<0||j>=cols||grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for(int[] d:directions){
            int di = i+d[0], dj = j+d[1];
            dfs(grid, di, dj, rows, cols);
        }
    }
}
