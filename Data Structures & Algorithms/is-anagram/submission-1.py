class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        cnts, cntt=Counter(s), Counter(t)
        if cnts!=cntt:
            return False
        else:
            return True