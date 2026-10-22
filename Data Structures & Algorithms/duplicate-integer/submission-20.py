class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hs = set() 
        for e in nums: 
            if e in hs:
                return True
            else:
                hs.add(e)
        return False

        