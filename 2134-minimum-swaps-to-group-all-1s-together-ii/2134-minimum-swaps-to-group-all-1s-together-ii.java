class Solution {
    public int minSwaps(int[] nums) {
        int windowSize=0;
        for(int num : nums){
            windowSize+=num;
        }
        int curZeros=0;
        for(int i=0;i<windowSize;i++){
            if(nums[i]==0){
                curZeros++;
            }
        }
        int minZeros = curZeros;
        int start=0;
        int end = windowSize-1;
        int n = nums.length;
        while(start<n){
            if(nums[start]==0){
                curZeros--;
            }
            start++;
            end++;
            if(nums[end%n]==0){
                curZeros++;
            }
            minZeros=Math.min(minZeros, curZeros);
        }
        return minZeros;
    }
}