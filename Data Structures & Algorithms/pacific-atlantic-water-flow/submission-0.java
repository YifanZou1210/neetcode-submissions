class Solution {
    // 定义方向数组：上，下，左，右
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        rows = heights.length;
        cols = heights[0].length;

        // 创建两个布尔矩阵，分别记录从太平洋和大西洋能到达的位置
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 从太平洋边界出发（第一行 & 第一列）
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, rows - 1, j);
        }

        // 找出两个矩阵都为 true 的坐标
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    // 反向 DFS：从边界出发，只向高度相同或更高的方向走
    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        // 如果已经访问过，直接返回
        if (visited[i][j]) return;

        // 标记当前点为已访问
        visited[i][j] = true;

        // 遍历四个方向
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            // 边界检查
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                continue;
            }

            // 只能从当前点走到相邻更高或等高的点（反向流动）
            if (heights[newRow][newCol] >= heights[i][j]) {
                dfs(heights, visited, newRow, newCol);
            }
        }
    }
}
