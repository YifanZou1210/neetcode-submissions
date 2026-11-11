class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 1. hashmap -> frequency -> top k integer 
        hm = defaultdict(int)
        for v in nums: 
            hm[v]+=1 
        pairs = sorted(hm.items(), key = lambda k: -k[1])
        return [num for num, _ in pairs[:k]] 