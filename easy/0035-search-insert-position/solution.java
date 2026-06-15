                return mid;
            }else if(nums[mid]<target){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return -1;
    }
            if(nums[mid]==target){

             int mid=s+(e-s)/2;
