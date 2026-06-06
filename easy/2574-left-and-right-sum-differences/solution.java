       leftSum[0]=0;
       for(int i=1;i<nums.length;i++){
        leftSum[i]=leftSum[i-1]+nums[i];
       }

       int rightSum=0;
       for(int i=nums.length-1;i>=0;i--){
       }
        leftSum[i]=leftSum[i]+rightSum;
        rightSum=rightSum+nums[i];

       return leftSum;
    }
