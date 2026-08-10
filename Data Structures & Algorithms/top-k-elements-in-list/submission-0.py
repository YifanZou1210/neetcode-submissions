from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        fre = Counter(nums)
        sorted_items = sorted(fre.items(), key=lambda x: x[1], reverse=True)
        return [item[0] for item in sorted_items[:k]]
