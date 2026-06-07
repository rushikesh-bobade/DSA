class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=0;
        int count=0;

        for(int i =0;i<nums.length;i++){
            count=count+nums[i];
            maxSum=Math.max(maxSum,count);
            if(count<0){
                count=0;
            }
        }
    return maxSum;
    }
    
}