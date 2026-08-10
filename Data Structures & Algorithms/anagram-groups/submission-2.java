class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(hm.containsKey(key)!=true){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
