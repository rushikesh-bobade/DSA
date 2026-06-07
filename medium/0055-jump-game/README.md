# Jump Game

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 88.04%)  
**Memory:** 47.9 MB (beats 41.38%)  
**Submitted:** 2026-06-07T15:05:40.691Z  

```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/jump-game/)