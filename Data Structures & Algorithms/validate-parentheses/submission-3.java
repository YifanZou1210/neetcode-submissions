class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();  // 栈用于保存未闭合的左括号

        // 左括号到右括号的匹配映射
        Map<Character, Character> match = new HashMap<>();
        match.put('(', ')');
        match.put('[', ']');
        match.put('{', '}');

        for (char c : s.toCharArray()) {
            // 如果栈不为空，且当前字符刚好是栈顶左括号的匹配右括号
            if (!stk.isEmpty() && match.containsKey(stk.peek()) && match.get(stk.peek()) == c) {
                stk.pop();  // 配对成功，弹出左括号
            } else {
                stk.push(c);  // 否则入栈（可能是左括号或非法右括号）
            }
        }

        // 栈空说明所有括号都被匹配掉了
        return stk.isEmpty();
    }
}

