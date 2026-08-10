class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        int pres = 1;
        int sufs = 1;
        pre[0] = pres;
        suf[nums.length-1] = sufs;
        for(int i = 1; i<nums.length; i++){
            pres*=nums[i-1];
            pre[i] = pres;
        }
        for(int i = nums.length-2; i>=0; i--){
            sufs*=nums[i+1];
            suf[i] = sufs;
        }
        System.out.print(Arrays.toString(pre));
        System.out.print(Arrays.toString(suf));
        int [] res = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            res[i] = pre[i]*suf[i];
        }
        return res;
    }
}  
