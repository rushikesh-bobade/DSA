# Search Insert Position

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 
Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2


Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1


Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


 
Constraints:


	1 <= nums.length <= 104
	-104 <= nums[i] <= 104
	nums contains distinct values sorted in ascending order.
	-104 <= target <= 104

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.5 MB (beats 81.90%)  
**Submitted:** 2026-06-15T20:44:01.204Z  

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;


        while(s<=e){
             int mid=(s+e)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return s;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/search-insert-position/)