class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num:nums){
            if(hm.getOrDefault(num, 0)!=0){
                return true;
            }
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        return false;
    }
}