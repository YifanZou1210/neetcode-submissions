class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int x: nums){
            if(hs.contains(x)==true){
                return true;
            }
            hs.add(x);
        }
        return false;
    }
}