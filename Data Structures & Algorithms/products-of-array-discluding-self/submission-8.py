class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums) 
        res = [1]*length 
        # 1 1 1 1 
        # 1 1 2 8 
        for i in range(1, length): 
            res[i]=nums[i-1]*res[i-1]
        # print(res)
        suffix = 1 
        # 48 24 6 1 
        for i in range(length-2, -1, -1): 
            suffix*=nums[i+1]
            res[i]*=suffix 

        return res
        