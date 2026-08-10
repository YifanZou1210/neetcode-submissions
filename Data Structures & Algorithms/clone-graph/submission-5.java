/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> used = new HashMap<>();
        return dfs(node, used);
    }
    private Node dfs(Node node, Map<Node, Node> used){
        if(used.containsKey(node)) return used.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        used.put(node, clone);
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(dfs(neighbor, used));
        }
        return clone;
    }
}