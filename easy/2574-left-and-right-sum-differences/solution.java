       int leftSum[]=new int [nums.length];
    public int[] leftRightDifference(int[] nums) {
class Solution {
       leftSum[0]=0;
       for(int i=1;i<nums.length;i++){
        leftSum[i]=leftSum[i-1]+nums[i];
       }

       int rightSum[]=new int [nums.length];
       for(int i=nums.length-1;i>0;i--){
        leftSum[i]=leftSum[i]-rightSum[i];
       }

       return leftSum;
    }
        rightSum[i]=nums[i]+rightSum[i];
       rightSum[nums.length-1]= 0;
}
