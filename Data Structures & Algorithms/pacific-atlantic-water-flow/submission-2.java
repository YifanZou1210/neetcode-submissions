class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific, grid);             // 左边界（太平洋）
            dfs(i, cols - 1, atlantic, grid);     // 右边界（大西洋）
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, pacific, grid);             // 上边界（太平洋）
            dfs(rows - 1, j, atlantic, grid);     // 下边界（大西洋）
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] ocean, int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (ocean[i][j]) return;
        ocean[i][j] = true;

        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || ni >= rows || nj < 0 || nj >= cols || grid[ni][nj]<grid[i][j]) continue;
            dfs(ni, nj, ocean, grid);
        }
    }
}
