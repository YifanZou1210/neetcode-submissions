class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(i, j, 0, word, board, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int idx, String word, char[][] board, boolean [][] visited){
        int rows = board.length, cols = board[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] == true || board[i][j] != word.charAt(idx)){
            return false;
        }
        if(idx == word.length()-1) return true;
        int[][] directions = new int[][]{{-1, 0},{1, 0},{0, 1},{0,-1}};
        visited[i][j] = true;
        for(int[] d: directions){
            int ri = d[0]+i, rj = d[1]+j;
            if(dfs(ri, rj, idx+1, word, board, visited))return true;
        }
        visited[i][j] = false;
        return false;
    }
}
