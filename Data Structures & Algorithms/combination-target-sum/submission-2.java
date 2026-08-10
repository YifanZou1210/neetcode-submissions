class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, target, path, res);
        return res;
    }
    private void backtrack(int[] nums, int idx, int rest, List<Integer> path, List<List<Integer>> res){
        if(rest == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i = idx; i<nums.length;i++){
            if(nums[i]>rest) continue;
            path.add(nums[i]);
            backtrack(nums, i, rest-nums[i], path, res);
            path.remove(path.size()-1);
        }
    }
}
