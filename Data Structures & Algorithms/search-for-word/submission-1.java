class Solution {
    private int rows, cols;
    private char[][] board;
    private String word;
    private static final int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word;
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(i, j, 0)) return true;
            }
        }return false;
    }
    private boolean dfs(int i, int j, int idx){
        if(i<0||i>=rows||j<0||j>=cols ||board[i][j]!=word.charAt(idx)){
            return false;
        }
        if(idx == word.length()-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        for(int [] d:directions){
            int ni = i+d[0], nj = j+d[1];
            if(dfs(ni, nj, idx+1)){
                //backtrack恢复现场，给后续recur使用空间
                board[i][j] = temp;
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}
