# Maximum Total Subarray Value I

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 62.3 MB (beats 38.13%)  
**Submitted:** 2026-06-09T17:45:17.069Z  

```java
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        return (long) (mx - mn) * k;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-total-subarray-value-i/)