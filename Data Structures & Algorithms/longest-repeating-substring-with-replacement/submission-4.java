class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int len = s.length();
        int maxValue = 0; 
        int maxlen = 0; 
        for(int r = 0; r<s.length(); r++){
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0)+1);
            maxValue = Math.max(maxValue, hm.getOrDefault(s.charAt(r), 0));
            while(r-l+1-maxValue>k){
                char left = s.charAt(l);
                hm.put(left, hm.get(left)-1);
                l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}
