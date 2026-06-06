       int rightSum=0;
       for(int i=nums.length-1;i>0;i--){
        leftSum[i]=leftSum[i]-rightSum;
        rightSum+=nums[i--];
       }

       }
        leftSum[i]=leftSum[i-1]+nums[i];

       return leftSum;
    }
}
       for(int i=1;i<nums.length;i++){
       leftSum[0]=0;
       int leftSum[]=new int [nums.length];
    public int[] leftRightDifference(int[] nums) {
class Solution {
