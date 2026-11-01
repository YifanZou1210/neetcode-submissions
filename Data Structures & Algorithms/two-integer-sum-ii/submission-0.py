class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        hm = defaultdict(int) 
        for k, v in enumerate(numbers): 
            if target-v in hm: 
                return [hm[target-v]+1, k+1]
            hm[v] = k 
        return [] 