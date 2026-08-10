class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> hm = new HashMap<>();
        hm.put('(',')');
        hm.put('{','}');
        hm.put('[',']');
        for(char c: s.toCharArray()){
            if(hm.containsKey(c)){
                stk.push(c);
            }else if(hm.containsValue(c)){
                if(stk.isEmpty()||hm.get(stk.peek())!=c){
                    return false;
                }
                else{
                    stk.pop();
                }
        }
        }
    return stk.isEmpty();
}
}

