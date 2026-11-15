class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        hm = defaultdict(int)
        for i, v in enumerate(numbers): 
            if target-v in hm: 
                return [hm[target-v]+1, i+1]
            hm[v]= i 
        return []