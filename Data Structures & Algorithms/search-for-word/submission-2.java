class Solution {
    //在java中局部变量的作用域只限于其所在的方法内部或者代码块内部。在外部function中定义的变量无法在嵌套内部方法
    //中使用，除非1. 作为参数传入 2. 设置为类的字段
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0; i< rows;i++){
            for(int j = 0; j< cols;j++){
                if (board[i][j]==word.charAt(0)){
                    if(dfs(board, word, i, j, 0, rows, cols, visited)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int idx, int rows, int cols, boolean[][] visited){
        int[][] directions = {{-1, 0},{1, 0},{0, -1}, {0, 1}};
        if(i<0||i>=rows||j<0||j>=cols||board[i][j]!=word.charAt(idx)||visited[i][j]){
            return false;
        }
        if(idx == word.length()-1) return true;
        //该(i, j)是匹配后的点
        visited[i][j] = true;
        for(int[] d:directions){
            int di = i+d[0], dj = j+d[1];
            //尝试所有方向
            if(dfs(board, word, di, dj, idx+1, rows, cols, visited)){
                //成功则继续深入
                return true;
            }
        }
        //如果所有方向都失败，就要撤销当前起点的选择
        visited[i][j] = false;
        //标注当前(i, j)是失败路径，走到上一级尝试下一个方向
        return false;
    }
}
