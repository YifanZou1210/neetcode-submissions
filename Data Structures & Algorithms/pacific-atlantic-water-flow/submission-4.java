class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean [][] pacific = new boolean[rows][cols];
        boolean [][] atlantic  = new boolean[rows][cols];
        for( int i = 0; i<rows; i++){
            dfs(i, 0, pacific, heights);
            dfs(i, cols-1, atlantic, heights);
        }
        for(int j = 0; j <cols; j++){
            dfs(0, j, pacific, heights);
            dfs(rows-1, j, atlantic, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(pacific[i][j]==true && atlantic[i][j]==true){
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return res;
        
    }
    private void dfs(int i, int j, boolean[][] ocean, int[][] heights){
        int rows = heights.length, cols = heights[0].length;
        if(ocean[i][j]) return;
        ocean[i][j] = true;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1},{0,1}};
        for(int[] d: directions){
            int ri = d[0]+i, rj = d[1]+j;
            if(ri<0 || ri>=rows || rj<0 || rj>= cols || heights[ri][rj]<heights[i][j]){
                continue;
            }
            dfs(ri, rj, ocean, heights);
        }

    }
}
