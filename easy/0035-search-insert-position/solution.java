            }else{
                s=mid+1;
            }else if(nums[mid]<target){
                return mid;
                e=mid-1;
            }
        }
        return -1;
    }
}
