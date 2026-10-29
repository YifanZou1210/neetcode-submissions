class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = defaultdict() 
        for k, v in enumerate(nums): 
            if target-v in hm: 
                return [hm[target-v], k]
            hm[v]= k 
        return []