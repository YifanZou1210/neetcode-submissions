class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character,Character> match = Map.of(
            '[',']',
            '{','}',
            '(',')'
        );
        for (char ch : s.toCharArray()) {
            // 左括号 → 入栈
            if (match.containsKey(ch)) {
                stk.push(ch);
            } else {
                // 右括号但栈空或不匹配 → 无效
                if (stk.isEmpty() || match.get(stk.pop()) != ch) {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
