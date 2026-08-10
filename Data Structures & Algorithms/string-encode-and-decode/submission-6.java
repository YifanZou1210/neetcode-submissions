class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int len = str.length();
            sb.append(len);
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int cur = 0;
        List<String> res = new ArrayList<>();
        while(cur<str.length()){
            int pre = cur;
            while(str.charAt(cur)!='#'){
                cur+=1;
            }
            String len = str.substring(pre, cur);
            int length = Integer.parseInt(len);
            cur+=1;
            res.add(str.substring(cur, cur+length));
            cur+=length;
        }
        return res;
    }
}
