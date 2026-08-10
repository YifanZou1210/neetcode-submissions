class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(nums, 0, target, res, path);
        return res;
    }

    private void backtrack(int[] nums, int start, int rest, List<List<Integer>> res, List<Integer> path){
        if(rest == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(rest<0) return ;
        for(int i = start; i< nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i, rest-nums[i],res, path);
            path.remove(path.size()-1);
        }
    }
}
