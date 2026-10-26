class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1 1 2 8 
        // 48 24 6 1 
        int len = nums.length; 
        int[] prefix = new int[len]; 
        int[] suffix = new int[len]; 
        prefix[0] = 1; 
        // i<len means i stops at len-1, which is end of prefix
        for(int i = 1; i<len; i++){
            prefix[i] = prefix[i-1]*nums[i-1]; 
        }
        suffix[len-1] = 1; 
        for(int i = len-2; i>=0; i--){
            suffix[i] = suffix[i+1]*nums[i+1]; 
        }
        // System.out.print(prefix.toString()); 
        int[] res = new int[len]; 
        for(int i = 0 ; i<len; i++){
            res[i] = prefix[i]*suffix[i]; 
        }
        return res; 
    }
}  
