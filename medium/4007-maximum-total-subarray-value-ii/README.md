# Maximum Total Subarray Value Ii

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** 72 ms (beats 93.75%)  
**Memory:** 151 MB (beats 65.63%)  
**Submitted:** 2026-06-10T17:58:43.470Z  

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