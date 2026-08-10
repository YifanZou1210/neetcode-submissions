class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int [] visited = new int[n];
        for(int i = 0; i<n; i++){
            if(!dfs(i, -1, visited, graph)) return false;
        }
        for(int v: visited){
            if(v == 0) return false;
        }
        
        return true;
    }
    private boolean dfs(int node, int parent, int[] visited, List<List<Integer>> graph){
        if(visited[node]==1) return false;
        if(visited[node]==2) return true;
        visited[node] = 1; 
        for(int neighbor: graph.get(node)){
            if(neighbor == parent) continue;
            if(!dfs(neighbor, node, visited, graph)) return false;
        }
        visited[node] = 2; 
        return true;
    }
}
