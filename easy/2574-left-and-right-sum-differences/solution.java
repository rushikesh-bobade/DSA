        leftSum[i]=leftSum[i-1]+nums[i];
       }

       int rightSum[]=new int [nums.length];
       rightSum[nums.length-1]= 0;
       for(int i=nums.length-2;i>0;i--){
        rightSum[i]=nums[i]+rightSum[i];
        leftSum[i]=leftSum[i]-rightSum[i];
       }

       return leftSum;
    }

}
