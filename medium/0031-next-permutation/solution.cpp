class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int ind = -1;
        //step 1 : lets find the element which is less previous from the end
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
            ind=i;
            break;
            }
        }

        //edge case if not found e.g. as [5,4,3,2,1] 
        if(ind==-1){
            reverse(nums.begin(),nums.end());
            return ;
        }

        //step 2: if found then found that element from last which is greater than index value
        for(int i=n-1;i>=ind;i--){
            if(nums[i]>nums[ind]){
            swap(nums[ind],nums[i]);
            break;
            }
        }

        reverse(nums.begin()+ind+1,nums.end());


        //next_permutation(nums.begin(),nums.end()); //this is the cpp inbuild function to find out next permutation
    }
};