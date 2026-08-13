class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false; 
        Map<Character, Integer> hm = new HashMap<>(); 
        char[] slist = s.toCharArray(); 
        char[] tlist = t.toCharArray(); 
        for(char e: slist){
            hm.put(e, hm.getOrDefault(e, 0)+1); 
        }
        for(char e: tlist){
            if(!hm.containsKey(e)){
                return false; 
            }
            hm.put(e, hm.get(e)-1); 
            if(hm.get(e)<0){
                return false; 
            }
        }
        for(int count: hm.values()){
            if(count!=0) return false; 
        }
        return true; 
    }
}
