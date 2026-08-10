class Solution {
    public int countComponents(int n, int[][] edges) {
        // 1. 构建图（邻接表）
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]); // 无向图
            graph.get(edge[1]).add(edge[0]);
        }

        // 2. 标记是否访问过
        boolean[] visited = new boolean[n];
        int count = 0;

        // 3. 遍历所有节点，统计连通块
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true; // 当前节点打标
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor); // 递归访问邻居
            }
        }
    }
}
