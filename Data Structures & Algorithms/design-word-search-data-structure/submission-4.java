class WordDictionary {
    class TrieNode{
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
        TrieNode cur = root;
        return dfs(word, 0, cur);

    }

    private boolean dfs(String word, int idx, TrieNode cur){
        if(idx == word.length()) return cur.end;
        char node = word.charAt(idx);

        if(node != '.'){
            if(!cur.children.containsKey(node)){
                return false;
            }
            return dfs(word, idx+1, cur.children.get(node));
        }else{
            for(TrieNode c: cur.children.values()){
                if(dfs(word, idx+1, c)) return true;
                continue;
            }
            return false;
        }
    }
}
