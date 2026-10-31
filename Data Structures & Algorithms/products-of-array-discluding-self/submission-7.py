class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        # 1 1 2 8 
        # 48 24 6 1
        prefix, suffix = [1]*length, [1]*length 
        res = [1]*length
        for i in range(1, length): 
            prefix[i] = prefix[i-1]*nums[i-1]
        for i in range(length-2, -1, -1): 
            suffix[i] = suffix[i+1]*nums[i+1]
        for i in range(length): 
            res[i] = prefix[i]*suffix[i]
        return res 
        