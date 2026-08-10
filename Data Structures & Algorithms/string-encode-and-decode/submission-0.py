class Solution:
    # 避免特殊字符问题
    def encode(self, strs: List[str]) -> str:
        # 每个字符串变成：长度#内容
        return ''.join(f"{len(s)}#{s}" for s in strs)

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        while i < len(s):
            # 提取长度
            j = i
            while s[j] != '#':
                j += 1
            length = int(s[i:j])
            # 提取内容
            j += 1
            res.append(s[j:j + length])
            i = j + length
        return res
