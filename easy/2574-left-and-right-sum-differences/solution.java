       int rightSum=0;
       for(int i=nums.length-1;i>0;i--){
        leftSum[i]=leftSum[i]-rightSum;
        rightSum+=nums[i];
       }

       }
        leftSum[i]=leftSum[i-1]+nums[i];

       return leftSum;
