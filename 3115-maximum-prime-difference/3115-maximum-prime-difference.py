class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        def is_prime(x):
            if x==1:
                return False
            i=2
            while i*i<=x:
                if x%i==0:
                    return False
                i+=1
            return True
        indices=[]
        for index, x in enumerate(nums):
            if is_prime(x):
                indices.append(index)
        assert(len(indices)>0)
        return indices[-1]-indices[0]