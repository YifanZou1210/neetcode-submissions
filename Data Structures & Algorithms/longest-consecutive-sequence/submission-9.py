class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0 
        hs = set(nums)
        for v in hs: 
            ans = 1 
            if v-1 not in hs: 
                # if we find one element as first idx, larger one sits left aside it, how should we find that? larger num not leftside cur is okay, trick not relay on order of nums 
                start = v 
                cur = start+1 
                while cur in hs: 
                    ans+=1 
                    cur+=1 
                res = max(res, ans)
        return res



