class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for v in strs: 
            res+=str(len(v))+"#"+v 
        return res 
    def decode(self, s: str) -> List[str]:
        res = [] 
        i = 0 
        while i<len(s): 
            r = s.index("#", i)
            if r: 
                str_len = int(s[i:r])
                res.append(s[r+1:r+1+str_len])
                i = r+1+str_len
        return res
