class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = Counter()
        mx = 0
        l = 0
        for r, num in enumerate(s):
            freq[num]+=1
            while r-l+1-max(freq.values())>k:
                freq[s[l]]-=1
                if not freq[s[l]]:
                    del freq[s[l]]
                l+=1
            mx = max(mx, r-l+1)
        return mx