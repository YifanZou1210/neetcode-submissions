class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        // 超界 or 已访问 or 不匹配当前字符
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // 全部字符匹配完了
        if (index == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        int[][] dirts = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] d : dirts) {
            int ni = i + d[0], nj = j + d[1];
            if (backtrack(board, word, ni, nj, index + 1, visited)) {
                return true;
            }
        }
        visited[i][j] = false; // 回溯
        return false;
    }
}
