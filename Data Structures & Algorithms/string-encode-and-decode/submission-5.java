class Solution {

    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            string.append(length);
            string.append('#');
            string.append(str);
        }
        return string.toString();
    }

    public List<String> decode(String str) {
        int cur = 0;
        List<String> res = new ArrayList<>();
        while(cur<str.length()){
            int pre = cur;
            while(str.charAt(cur)!='#'){
                cur+=1;
            }
            int length = Integer.parseInt(str.substring(pre, cur));
            cur+=1;
            String substring = str.substring(cur, cur+length);
            cur+=length;
            res.add(substring);
        }
        return res;
    }
}
