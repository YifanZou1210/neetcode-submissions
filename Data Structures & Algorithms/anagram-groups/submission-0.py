class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hm = defaultdict(list)
        for num in strs:
            print(sorted(num))
            key = ''.join(sorted(num))
            hm[key].append(num)
        print(hm.values())
        return list(hm.values())
        # return [value for value in hm.values()]