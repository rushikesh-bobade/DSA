# Jump Game

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 88.04%)  
**Memory:** 48 MB (beats 22.72%)  
**Submitted:** 2026-06-07T15:04:02.728Z  

```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex=0;

        for(int i=0;i<nums.length;i++){
            
            if(i>maxIndex){
                return false;
            }
            maxIndex=Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/jump-game/)