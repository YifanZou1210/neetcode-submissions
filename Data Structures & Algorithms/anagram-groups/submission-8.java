class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>(); 
        for(String str: strs){
            char[] strchar = str.toCharArray(); 
            Arrays.sort(strchar); 
            String k = String.valueOf(strchar); 
            if(hm.containsKey(k)){
                hm.compute(k, (key, oldList)->{
                    oldList.add(str); 
                    return oldList; 
                }); 
            }else{
                List<String> list = new ArrayList<>(); 
                list.add(str); 
                hm.put(k, list); 
            }
        }
        return new ArrayList<>(hm.values()); 
    }
}
