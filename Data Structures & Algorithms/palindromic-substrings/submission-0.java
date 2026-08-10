class Solution {
    public int countSubstrings(String s) {
        if(s.length()<=0 || s == null) return 0;
        int cnt = 0;
        for(int i = 0; i<s.length();i++){
            cnt += expand(s, i, i)+expand(s, i, i+1);
        }
        return cnt;
    }
    private int expand(String s, int l, int r){
        int cnt = 0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            cnt+=1;
            l-=1;
            r+=1;
        }
        return cnt;
    }
}
