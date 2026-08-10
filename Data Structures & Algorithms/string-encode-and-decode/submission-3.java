class Solution {
// 这道题关键在于String中可能包含任意字符包括常用的,或者#不能只依赖简单的分隔符
// 记录每个字符串长度
// 组合长度/分隔符/原字符串
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            String s = str.substring(j, j+length);
            res.add(s);
            i = j+length;
        }
        return res;
    }
}
