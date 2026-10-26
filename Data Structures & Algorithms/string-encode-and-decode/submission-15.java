class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        for(String str: strs){
            int length = str.length(); 
            sb.append(length); 
            sb.append("#"); 
            sb.append(str); 
        }
        return sb.toString(); 
    }

    public List<String> decode(String str) {
        int idx = 0; 
        int totalLength = str.length(); 
        List<String> res = new ArrayList<>(); 
        while(idx<totalLength){
            //collect digits for length
            StringBuilder numsb = new StringBuilder(); 
            //check current char every loop iteration 
            while(str.charAt(idx)!='#'){
                numsb.append(str.charAt(idx)); 
                idx++; 
            }
            idx++; //skip #
            int wordLen = Integer.parseInt(numsb.toString()); 
            //take substring directly 
            String word = str.substring(idx, idx+wordLen);
            res.add(word); 
            idx+=wordLen; 
        }
        return res; 
    }
}
