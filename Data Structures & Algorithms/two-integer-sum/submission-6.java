class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>(); 
        for(int i = 0; i<nums.length; i++){
            int value = nums[i]; 
            if(hm.containsKey(target-value)){
                return new int[] {hm.get(target-value), i}; 
            }
            hm.put(value, i); 
        }
        return new int[]{}; 
    }
}
