
        if(left==-1){
            return;
        }

        for(int i=left+1;i<nums.length;i++){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                left++;
            }

