class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length()<1) return "";
        int start = 0, end = 0;
        for(int i = 0; i<s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len> end-start+1){
                start = i-(len-1)/2; // 统一奇偶长度处理的起始下标计算
                end = i+len/2; //计算新的结束下标
            }
        }
        return s.substring(start, end+1);
    }

    //return length of longest palindromic substring 
    private int expand(String s, int left, int right){
        while(left>=0&&right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        // when jump out from while loop, left and right has out of boundary
        // real zone should be [left+1, right-1], length is right-left+1-2
        return right-left-1;
    }
}
