class PrefixTree {
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }
    public PrefixTree() {
        root = new TrieNode(); 
    }
    private final TrieNode root;

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node=node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd;
    }


    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    private TrieNode searchPrefix(String str){
        TrieNode node = root;
        for(char c : str.toCharArray()){
            if(!node.children.containsKey(c)){
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }
}
