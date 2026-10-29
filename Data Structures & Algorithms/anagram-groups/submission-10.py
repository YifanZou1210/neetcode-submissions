class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hm = defaultdict(list) 
        for v in strs: 
            key = sorted(v) 
            hm[tuple(key)].append(v)
        return list(hm.values())