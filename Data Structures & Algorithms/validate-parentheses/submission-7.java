class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> hm = new HashMap<>();
        hm.put('(',')');
        hm.put('{','}');
        hm.put('[',']');
        for(char str: s.toCharArray()){
            if(hm.containsKey(str)){
                stk.push(str);
            }else if (hm.containsValue(str)){
                if(stk.isEmpty() || hm.get(stk.peek())!=str){
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

