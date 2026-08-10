class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hms = new HashMap<>();
        Map<Character, Integer> hmt = new HashMap<>();
        for(char c: s.toCharArray()){
            hms.put(c, hms.getOrDefault(c, 0)+1);
        }
        for(char c:t.toCharArray()){
            hmt.put(c, hmt.getOrDefault(c, 0)+1);
        }
        if(hms.equals(hmt)){
            return true;
        }
        return false;
    }
}
