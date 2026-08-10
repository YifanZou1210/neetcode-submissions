class WordDictionary {
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end = false;
    }
    TrieNode root; 
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
        TrieNode cur = root;
        return dfs(word, 0, cur);
    }
    private boolean dfs(String word, int idx, TrieNode cur){
        if(idx == word.length()) return cur.end;
        char c = word.charAt(idx);
        if(c!='.'){
            if(cur.children.get(c)==null) return false;
            return dfs(word, idx+1, cur.children.get(c));
        }else{
            for(TrieNode node: cur.children.values()){
                if(dfs(word, idx+1, node)) return true;
            }
            return false;
        }
        
    }
}
