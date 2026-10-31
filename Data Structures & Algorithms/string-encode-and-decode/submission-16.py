class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for v in strs: 
            res+=str(len(v))+"#"+v 
        return res 

    def decode(self, s: str) -> List[str]:
        idx = 0
        res = [] 
        while idx<len(s): 
            r = idx+1 # 1 
            while s[r]!="#": 
                r+=1 
            lenofword = int(s[idx:r]) 
            first = r+1  
            end = first+lenofword  
            res.append(s[first:end])
            idx = end 
        return res

                
