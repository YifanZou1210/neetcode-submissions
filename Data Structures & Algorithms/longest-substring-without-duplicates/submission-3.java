class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int l = 0, r = 0, maxLen = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            while(window.contains(c)){
                window.remove(s.charAt(l));
                l++;
            }
            window.add(c);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
