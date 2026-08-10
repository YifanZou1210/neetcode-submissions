class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        cnt = Counter(nums)
        if len(cnt)!=len(nums):
            return True
        else:
            return False