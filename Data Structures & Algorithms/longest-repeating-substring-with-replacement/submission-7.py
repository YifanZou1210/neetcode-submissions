class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        hm = defaultdict(int)
        res = 0 
        l = 0 
        for r in range(len(s)):
            hm[s[r]]+=1
            while r-l+1-max(hm.values())>k: 
                hm[s[l]]-=1
                l+=1
                if l<len(s) and not hm[s[l]]: 
                    del hm[s[l]]
            res = max(res, r-l+1)
        return res