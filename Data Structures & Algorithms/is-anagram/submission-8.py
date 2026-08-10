class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        cnt1, cnt2 = Counter(s), Counter(t)
        if len(s) != len(t):
            return False
        if len(cnt1)>len(cnt2):
            cnt2, cnt1 = cnt1, cnt2
        for k, v in cnt1.items():
            if k not in cnt2.keys() or cnt2[k]!=v:
                return False 
        return True 
        