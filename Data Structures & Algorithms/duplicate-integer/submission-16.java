class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>(); 
        for(int e: nums){
            if(hs.contains(e)){
                return true; 
            }
            hs.add(e); 
        }
        return false; 
        
    }
}