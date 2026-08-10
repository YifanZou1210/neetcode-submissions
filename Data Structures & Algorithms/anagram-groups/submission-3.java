class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String str: strs){
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sort = new String(sorted);
            hm.computeIfAbsent(sort, k->new ArrayList()).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
