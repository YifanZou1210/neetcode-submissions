class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}
        l = 0
        max_len = 0

        for r in range(len(s)):
            c = s[r]
            if c in char_index and char_index[c] >= l:
                l = char_index[c] + 1  # 移动左边界
            char_index[c] = r
            max_len = max(max_len, r - l + 1)

        return max_len

            