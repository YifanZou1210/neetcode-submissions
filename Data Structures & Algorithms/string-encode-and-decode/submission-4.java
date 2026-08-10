class Solution {

    public String encode(List<String> strs) {
        StringBuilder strlist = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            strlist.append(length).append('#').append(str);
        }
        return strlist.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            String len = str.substring(i, j);
            int length = Integer.parseInt(len);
            j++;
            res.add(str.substring(j, j+length));
            i = j+length;
        }
        return res;
    }
}
