class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dic = Counter(nums)
        items = sorted(
            dic.items(), 
            key = lambda item: item[1], 
            reverse = True 
        )
        return [num for num, frequency in items[:k]]
        
        
        