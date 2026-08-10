class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int l = i+1, r = nums.length-1;
            while(l<r){
                int total = nums[i]+nums[l]+nums[r];
                if(total == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l+=1;
                    r-=1;
                }
                else if( total < 0){
                    l+=1;
                }
                else{
                    r-=1;
                }
            }
        }
        return res;
    }
}
