class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        Set<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        for(int e: hs){
            if(!hs.contains(e-1)){
                int cur = e;
                int tmp = 1;
                while(hs.contains(cur+1)){
                    cur+=1;
                    tmp+=1;
                }
                maxlen = Math.max(maxlen, tmp);
            }
        }
        return maxlen;
    }
}
