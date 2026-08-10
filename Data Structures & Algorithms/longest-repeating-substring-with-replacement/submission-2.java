class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0, maxFreq = 0, maxLen = 0;
        for(int r = 0; r<s.length();r++){
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0)+1);
            maxFreq = Math.max(maxFreq, freq.get(c));
            while((r-l+1)-maxFreq>k){
                char left = s.charAt(l);
                freq.put(left, freq.get(left)-1);
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
}
}
