class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end = false;
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int idx, TrieNode cur){
        if(idx == word.length()) return cur.end;

        char str = word.charAt(idx);
        if(str == '.'){
            for(TrieNode node: cur.children.values()){
                //在当前 cur 节点上循环遍历多个子节点
                if(dfs(word, idx+1, node)) return true;
                // cur = cur.children.get(node);此时更新cur会破坏掉当前节点所有分支遍历逻辑
            }
            return false;
        }else{
            if(!cur.children.containsKey(str)) return false;
            return dfs(word, idx+1, cur.children.get(str));
        }
    }
}
