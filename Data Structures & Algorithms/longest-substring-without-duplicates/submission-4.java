class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int l = 0,maxLen = 0;
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);
            if(window.containsKey(c)&&window.get(c)>=l){
                l=window.get(c)+1;
            }
            window.put(c, r);
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
