class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.replace(" ", "")
        l, r = 0, len(s)-1 
        print(s)
        while l<=r: 
            a, b = s[l].lower(), s[r].lower() 
            if a.isalnum() is False: 
                l+=1 
                continue 
            if b.isalnum() is False: 
                r-=1 
                continue 
            if a!=b: 
                return False 
            l+=1 
            r-=1
        return True 