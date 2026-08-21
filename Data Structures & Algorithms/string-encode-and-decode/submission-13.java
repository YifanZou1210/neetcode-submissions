class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        for(String st: strs){
            sb.append(st.length()); 
            sb.append("#"); 
            sb.append(st); 
        }
        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>(); 
        int i = 0; 
        while(i<str.length()){
            int j = str.indexOf("#", i); 
            int len = Integer.parseInt(str.substring(i, j)); 
            System.out.print(len); 
            i = j+1; 
            String s = str.substring(i, i+len); 
            res.add(s);
            i+=len; 
        }
        return res; 
    }
}
