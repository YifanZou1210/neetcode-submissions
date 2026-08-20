class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>(); 
        for(String e: strs){
            char[] chars = e.toCharArray(); 
            Arrays.sort(chars); 
            String key = new String(chars); 
            hm.computeIfAbsent(key, k->new ArrayList<>()).add(e); 
        }
        return new ArrayList<>(hm.values()); 
    }
}
