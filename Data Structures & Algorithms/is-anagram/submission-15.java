class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false; 
        Map<Character, Integer> hm = new HashMap<>(); 
        for(char key: s.toCharArray()){
            hm.put(key, hm.getOrDefault(key, 0)+1); 
        }
        for(char key: t.toCharArray()){
            if(!hm.containsKey(key)){
                return false; 
            }else{
                hm.put(key, hm.get(key)-1); 
            }
            if(hm.get(key)<0) return false; 
        }
        return true; 
    }
}
