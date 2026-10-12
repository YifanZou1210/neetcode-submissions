class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false; 
        HashMap<Character, Integer> dic = new HashMap<>(); 
        for(char e: s.toCharArray()){
            dic.put(e, dic.getOrDefault(e, 0)+1); 
        }
        for(char n: t.toCharArray()){
            if(dic.containsKey(n)){
                dic.put(n, dic.getOrDefault(n, 0)-1); 
            }
        }
        // System.out.print(dic.values()); 
        for(int v: dic.values()){
            if(v!=0) return false; 
        }
        return true; 
    }
}
