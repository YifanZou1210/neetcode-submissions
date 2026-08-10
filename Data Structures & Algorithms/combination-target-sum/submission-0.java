class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, target, path,res);
        return res;
    }
    private void dfs(int[] nums, int start, int target, List<Integer> path, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(nums[i]>target) continue;
            path.add(nums[i]);
            dfs(nums, i, target-nums[i], path, res);
            path.remove(path.size()-1);
        }
    }
}
