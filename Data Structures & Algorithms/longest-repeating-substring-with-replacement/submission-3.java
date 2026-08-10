class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> fre = new HashMap<>();
        int l = 0;
        int maxlen = 0;
        int maxfre = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            fre.put(c, fre.getOrDefault(c, 0) + 1);

            maxfre = Math.max(maxfre, fre.get(c)); // 更新当前窗口内的最大字符频率

            // 当前窗口长度 - 最频繁字符的频率 > k，说明不能全变成 maxfre 的字符，需要缩小窗口
            while (r - l + 1 - maxfre > k) {
                char cl = s.charAt(l);
                fre.put(cl, fre.get(cl) - 1);
                l++; // 缩小窗口左边界
            }

            maxlen = Math.max(maxlen, r - l + 1); // 更新结果
        }

        return maxlen;
    }
}
