# Left And Right Sum Differences

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 98.84%)  
**Memory:** 46.4 MB (beats 84.77%)  
**Submitted:** 2026-06-06T14:02:38.594Z  

```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return answer;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/left-and-right-sum-differences/)