class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        //树构成有2个条件
        // 1. 无环 2. 任何2个节点都有联通
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];

        if(!dfs(0, -1, visited, graph)||visited.length!=n) return false;
        return true; 
    }
    // dfs遍历图，检查环，
    private boolean dfs(int node, int parent, int[] visited, List<List<Integer>> graph){
        if(visited[node] == 1) return false;
        if(visited[node] == 2) return true;
        visited[node] = 1;
        for(int neighbor: graph.get(node)){
            if(neighbor == parent) continue; //回头路不算是环
            if(!dfs(neighbor,node, visited, graph)) return false;
        }
        visited[node] = 2;
        return true;
    }
}
