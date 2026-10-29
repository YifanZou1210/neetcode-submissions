class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t): return False 
        hm = {} 
        for k, v in enumerate(s): 
            hm[v] = hm.get(v, 0)+1
        for k, v in enumerate(t): 
            hm[v] = hm.get(v, 0)-1 
        for k, v in hm.items(): 
            if v > 0: 
                return False 
        return True 
        