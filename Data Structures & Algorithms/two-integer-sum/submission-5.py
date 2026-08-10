class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic =  defaultdict(int)
        for k, v in enumerate(nums):
            if target-v in dic: 
                return sorted([k, dic[target-v]])
            dic[v] = k 
        