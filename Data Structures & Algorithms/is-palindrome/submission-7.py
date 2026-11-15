class Solution:
    def isPalindrome(self, s: str) -> bool:
        res = [num.lower() for num in s if num.isalnum()]
        print(res)
        return res == res[::-1]