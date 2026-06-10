# Maximum Total Subarray Value II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array nums of length n and an integer k.

You must select exactly k distinct subarrays nums[l..r] of nums. Subarrays may overlap, but the exact same subarray (same l and r) cannot be chosen more than once.

The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).

The total value is the sum of the values of all chosen subarrays.

Return the maximum possible total value you can achieve.

 
Example 1:


Input: nums = [1,3,2], k = 2

Output: 4

Explanation:

One optimal approach is:


	Choose nums[0..1] = [1, 3]. The maximum is 3 and the minimum is 1, giving a value of 3 - 1 = 2.
	Choose nums[0..2] = [1, 3, 2]. The maximum is still 3 and the minimum is still 1, so the value is also 3 - 1 = 2.


Adding these gives 2 + 2 = 4.


Example 2:


Input: nums = [4,2,5,1], k = 3

Output: 12

Explanation:

One optimal approach is:


	Choose nums[0..3] = [4, 2, 5, 1]. The maximum is 5 and the minimum is 1, giving a value of 5 - 1 = 4.
	Choose nums[1..3] = [2, 5, 1]. The maximum is 5 and the minimum is 1, so the value is also 4.
	Choose nums[2..3] = [5, 1]. The maximum is 5 and the minimum is 1, so the value is again 4.


Adding these gives 4 + 4 + 4 = 12.


 
Constraints:


	1 <= n == nums.length <= 5 * 10​​​​​​​4
	0 <= nums[i] <= 109
	1 <= k <= min(105, n * (n + 1) / 2)

## Solution

**Language:** Java  
**Runtime:** 1 ms  
**Memory:** 42.5 MB  
**Submitted:** 2026-06-10T18:18:28.897Z  

```java
import java.util.*;

class Solution {
    static class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    int[] lg;
    int[][] mx;
    int[][] mn;

    private long rangeValue(int l, int r) {
        int len = r - l + 1;
        int p = lg[len];
        int maxVal = Math.max(mx[p][l], mx[p][r - (1 << p) + 1]);
        int minVal = Math.min(mn[p][l], mn[p][r - (1 << p) + 1]);
        return (long) maxVal - minVal;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) lg[i] = lg[i >> 1] + 1;

        int m = lg[n] + 1;
        mx = new int[m][n];
        mn = new int[m][n];

        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }

        for (int p = 1; p < m; p++) {
            int len = 1 << p;
            int half = len >> 1;
            for (int i = 0; i + len <= n; i++) {
                mx[p][i] = Math.max(mx[p - 1][i], mx[p - 1][i + half]);
                mn[p][i] = Math.min(mn[p - 1][i], mn[p - 1][i + half]);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(rangeValue(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();
            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(rangeValue(cur.l, nr), cur.l, nr));
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-total-subarray-value-ii/)