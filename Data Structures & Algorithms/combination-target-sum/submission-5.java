class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, tmp, res, target);
        return res;

    }
    private void backtrack(int[] nums, int idx, List<Integer> tmp, List<List<Integer>> res, int rest){
        if(rest == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = idx; i< nums.length; i++){
            if(nums[i]>rest) break; //剪掉递归树当前branch的垂直分支
            //return终止当前递归调用，漏掉当前层后续所有可能路径
            tmp.add(nums[i]);
            backtrack(nums, i, tmp, res, rest-nums[i]);
            tmp.remove(tmp.size()-1);
        }
    }
}
