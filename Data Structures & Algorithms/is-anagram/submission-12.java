class Solution {
    public boolean isAnagram(String s, String t) {
        int[] fre = new int[26]; 
        if(s.length()<t.length()){
            String temp = s; 
            s = t; 
            t = temp; 
        }
        for(char c: s.toCharArray()){
            int index = c-'a'; 
            fre[index]+=1; 
        }
        for(char e: t.toCharArray()){
            int index = e-'a'; 
            fre[index]-=1; 
        }
        for(int e: fre){
            if(e>=1){
                return false; 
            }
        }
        return true; 
    }
}
