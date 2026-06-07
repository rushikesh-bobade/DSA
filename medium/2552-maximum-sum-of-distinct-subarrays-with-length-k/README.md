# Maximum Sum Of Distinct Subarrays With Length K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** 55 ms (beats 43.82%)  
**Memory:** 99.2 MB (beats 41.23%)  
**Submitted:** 2026-06-07T21:45:57.212Z  

```java
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0;
        long ans = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        if (freq.size() == k) {
            ans = sum;
        }

        // Slide the window
        for (int right = k; right < nums.length; right++) {

            int left = right - k;

            // Remove left element
            sum -= nums[left];

            freq.put(nums[left], freq.get(nums[left]) - 1);

            if (freq.get(nums[left]) == 0) {
                freq.remove(nums[left]);
            }

            // Add new right element
            sum += nums[right];

            freq.put(nums[right],
                    freq.getOrDefault(nums[right], 0) + 1);

            // Check validity
            if (freq.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/)