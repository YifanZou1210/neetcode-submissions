// class Solution {
//     public int[] getConcatenation(int[] nums) {
//         int[] result = new int[nums.length*2]; //n n 
//         for(int i = 0; i<nums.length*2; i++){
//             result[i] = nums[i%nums.length]; 
//         } //n n 
//         return result; 
//     }
// }    
// n n 

class Solution{
    public int[] getConcatenation(int[] nums){
        int n = nums.length; 
        int[] ans = new int[n*2]; 
        for(int i = 0; i<n; i++){
            ans[i] = nums[i]; 
            ans[i+n] = nums[i];
        }
        return ans; 
    }
}