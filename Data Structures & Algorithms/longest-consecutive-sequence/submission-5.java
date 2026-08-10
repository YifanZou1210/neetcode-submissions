class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        Set<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        for(int num: hs){
            if(hs.contains(num-1)==false){
                int cur = num;
                int tmp = 0;
                while(hs.contains(cur)){
                    cur+=1;
                    tmp+=1;
                }
                maxlen = Math.max(tmp, maxlen);
            }
        }
        return maxlen;
    }
}
