# Total Waviness of Numbers in Range II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given two integers num1 and num2 representing an inclusive range [num1, num2].

The waviness of a number is defined as the total count of its peaks and valleys:


	A digit is a peak if it is strictly greater than both of its immediate neighbors.
	A digit is a valley if it is strictly less than both of its immediate neighbors.
	The first and last digits of a number cannot be peaks or valleys.
	Any number with fewer than 3 digits has a waviness of 0.

Return the total sum of waviness for all numbers in the range [num1, num2].
 
Example 1:


Input: num1 = 120, num2 = 130

Output: 3

Explanation:

In the range [120, 130]:


	120: middle digit 2 is a peak, waviness = 1.
	121: middle digit 2 is a peak, waviness = 1.
	130: middle digit 3 is a peak, waviness = 1.
	All other numbers in the range have a waviness of 0.


Thus, total waviness is 1 + 1 + 1 = 3.


Example 2:


Input: num1 = 198, num2 = 202

Output: 3

Explanation:

In the range [198, 202]:


	198: middle digit 9 is a peak, waviness = 1.
	201: middle digit 0 is a valley, waviness = 1.
	202: middle digit 0 is a valley, waviness = 1.
	All other numbers in the range have a waviness of 0.


Thus, total waviness is 1 + 1 + 1 = 3.


Example 3:


Input: num1 = 4848, num2 = 4848

Output: 2

Explanation:

Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.


 
Constraints:


	1 <= num1 <= num2 <= 1015​​​​​​​

## Solution

**Language:** Java  
**Runtime:** 175 ms (beats 62.96%)  
**Memory:** 47.2 MB (beats 62.96%)  
**Submitted:** 2026-06-05T06:09:27.261Z  

```java
class Solution {
    private char[] s;
    private long[][][][][] cntMemo;
    private long[][][][][] wavMemo;
    private boolean[][][][][] seen;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;
        s = Long.toString(n).toCharArray();

        int m = s.length;
        cntMemo = new long[m][2][11][11][3];
        wavMemo = new long[m][2][11][11][3];
        seen = new boolean[m][2][11][11][3];

        long[] res = dfs(0, 0, 10, 10, 0, true);
        return res[1];
    }

    private long[] dfs(int pos, int started, int prev1, int prev2, int lenState, boolean tight) {
        if (pos == s.length) {
            return new long[]{1L, 0L};
        }

        if (!tight && seen[pos][started][prev1][prev2][lenState]) {
            return new long[]{
                cntMemo[pos][started][prev1][prev2][lenState],
                wavMemo[pos][started][prev1][prev2][lenState]
            };
        }

        long count = 0;
        long waviness = 0;

        int limit = tight ? s[pos] - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            boolean nt = tight && d == limit;

            if (started == 0 && d == 0) {
                long[] nxt = dfs(pos + 1, 0, 10, 10, 0, nt);
                count += nxt[0];
                waviness += nxt[1];
            } else if (started == 0) {
                long[] nxt = dfs(pos + 1, 1, d, 10, 1, nt);
                count += nxt[0];
                waviness += nxt[1];
            } else if (lenState == 1) {
                long[] nxt = dfs(pos + 1, 1, d, prev1, 2, nt);
                count += nxt[0];
                waviness += nxt[1];
            } else {
                int add = ((prev1 > prev2 && prev1 > d) || (prev1 < prev2 && prev1 < d)) ? 1 : 0;
                long[] nxt = dfs(pos + 1, 1, d, prev1, 2, nt);
                count += nxt[0];
                waviness += nxt[1] + nxt[0] * add;
            }
        }

        if (!tight) {
            seen[pos][started][prev1][prev2][lenState] = true;
            cntMemo[pos][started][prev1][prev2][lenState] = count;
            wavMemo[pos][started][prev1][prev2][lenState] = waviness;
        }

        return new long[]{count, waviness};
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/)