class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            int len = str.length();
            sb.append(len);
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int cur = 0;
        while(cur<str.length()){
            int pre = cur;
            while(str.charAt(cur)!='#'){
                cur++;
            }
            String len = str.substring(pre, cur);
            cur+=1;
            int length = Integer.parseInt(len);
            String tmp = str.substring(cur, cur+length);
            cur+=length;
            res.add(tmp);
        }
        return res;
    }
}
