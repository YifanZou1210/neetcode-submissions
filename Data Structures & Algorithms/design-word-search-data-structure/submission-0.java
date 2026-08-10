class WordDictionary {
    class Node{
        Map<Character, Node> children = new HashMap<>();
        boolean end = false;
    }
    private Node root; 
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for(char c: word.toCharArray()){
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Node node){
        if(i == word.length()) return node.end;
        char c = word.charAt(i);
        if(c!='.'){
            Node next = node.children.get(c);
            if(next == null) return false;
            return dfs(word, i+1, next);
        }else {
            for(Node child: node.children.values()){
                if(dfs(word, i+1, child)) return true;
            }
            return false;
        }
    }
}
