class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<r){
            if(Character.isLetterOrDigit(Character.toLowerCase(s.charAt(l)))==false){
                l++;
            }else if(Character.isLetterOrDigit(Character.toLowerCase(s.charAt(r)))==false){
                r--;
            }else{
                if(Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r))){
                    l++;
                    r--;
                }
                else{ return false;}
            }
        }
        return true;
    }
}
