class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int l = 0; 
        int maxlen = 0;
        for( int r = 0; r< s.length(); r++){
            char el = s.charAt(r);
            while(hs.contains(el)){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(el);
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}
