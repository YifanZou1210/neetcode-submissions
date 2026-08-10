class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length], suf = new int[nums.length];
        int sump = 1, sums = 1;
        pre[0] = 1;
        for(int i = 1; i<nums.length; i++){
            sump = pre[i-1]*nums[i-1];
            pre[i] = sump;
            System.out.println(pre[i]);
        }
        suf[nums.length-1] = 1;
        for(int i = nums.length-2; i>=0; i--){
            sums = suf[i+1]*nums[i+1];
            suf[i] = sums;
            System.out.println(suf[i]);
        }
        int [] res = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            res[i] = pre[i]*suf[i];
        }
        return res;
    }
}  
