class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hs = set(nums)
        mx = 0
        for num in hs:
            if num-1 not in hs:
                cur = num 
                cnt = 1
                while cur+1 in hs:
                    cur+=1
                    cnt+=1
                mx = max(mx, cnt)
        return mx
        