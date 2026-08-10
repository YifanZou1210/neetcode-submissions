class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s)-1
        while l<r:
            # isalnum()判断string是否只包含字母或者数字，如果包含空格标点符号等返回False
            if not s[l].isalnum():
                l+=1
                continue
            elif not s[r].isalnum():
                r-=1
                continue
            if s[l].lower()!=s[r].lower():
                return False
            l+=1
            r-=1
        return True