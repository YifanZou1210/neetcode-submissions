class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str1 = new String(chars);
            // 这个k在语法并没有用到但是必须写出来，表示当前缺失的key
            // k 是一个占位符参数，你传入的是一个 lambda 表达式 Function<String, List<String>>。
            // k 实际上等于 str1，只是函数调用时的形式参数。
            hm.computeIfAbsent(str1, k-> new ArrayList<>()).add(str);
            // 如果需要k参与逻辑，比如
            // hm.computeIfAbsent(str1, k-> new ArrayList<>(List.of(k)));
        }
        return new ArrayList<>(hm.values());
    }
}
