class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int maxLen = 0;
        for(int num:numSet){
            if(numSet.contains(num-1)==false){
                int cur = num;
                int tmp = 1;
                while(numSet.contains(cur+1)){
                    cur+=1;
                    tmp+=1;
                }
                maxLen = Math.max(maxLen, tmp);
            }
        }
        return maxLen;
        
    }
}
