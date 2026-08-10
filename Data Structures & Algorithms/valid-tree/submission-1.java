class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 剪枝：树必须是 n 个点 n-1 条边
        if (edges.length != n - 1) {
            return false;
        }

        // 构建邻接表，表示无向图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // 无向图要双向添加
        }

        // 用于记录节点是否被访问过
        boolean[] visited = new boolean[n];

        // 从节点 0 开始 DFS，初始父节点设为 -1
        if (hasCycle(0, -1, graph, visited)) {
            return false; // 有环
        }

        // 最后检查是否所有节点都被访问过（图是否连通）
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true; // 无环且连通，是合法树
    }

    // DFS 检查图中是否存在环
    private boolean hasCycle(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, graph, visited)) {
                    return true; // 子树中有环
                }
            } else if (neighbor != parent) {
                return true; // 访问了非父节点的已访问邻居 => 有环
            }
        }

        return false; // 当前节点及子树无环
    }
}

