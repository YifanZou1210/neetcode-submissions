class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            sb.append(length);
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strlist = new ArrayList<>();
        int cur = 0;
        while(cur<str.length()){
            int pre = cur;
            while(str.charAt(cur)!='#'){
                cur+=1;
            }
            String length = str.substring(pre, cur);
            cur+=1;
            int len = Integer.parseInt(length);
            strlist.add(str.substring(cur, cur+len));
            cur+=len;
        }
        return strlist;
    }
}
