class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0
        hs = set(nums)
        for v in hs:
            if v-1 in hs:
                continue 
            nxt = v+1 
            cnt = 1
            while nxt in hs: 
                nxt+=1
                cnt+=1 
            res = max(res, cnt)
        return res