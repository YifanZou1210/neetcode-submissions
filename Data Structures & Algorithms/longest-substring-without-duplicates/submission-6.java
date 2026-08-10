class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> fre = new HashSet<>();
        int l = 0;
        int maxlen = 0;
        for(int r = 0; r<s.length(); r++){
            while(fre.contains(s.charAt(r))){
                fre.remove(s.charAt(l));
                l++;
            }
            fre.add(s.charAt(r));
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}
