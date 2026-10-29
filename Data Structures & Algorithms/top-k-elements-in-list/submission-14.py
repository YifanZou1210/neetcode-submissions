class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums_fre = Counter(nums) 
        sorted_by_value = sorted(nums_fre.items(), key = lambda x: x[1], reverse = True)
        return [v[0] for v in sorted_by_value[:k]]