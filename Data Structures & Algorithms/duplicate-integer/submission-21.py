class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hs = set(); 
        for v in nums: 
            if v in hs: 
                return True
            hs.add(v) 
        return False
