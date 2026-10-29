class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hm = defaultdict(list)
        for v in strs:
            key = tuple(sorted(v))
            hm[key].append(v)
        return list(hm.values())