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
**Runtime:** 2 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-06-05T06:09:21.517Z  

```java
                waviness += nxt[1];
            } else {
                int add = ((prev1 > prev2 && prev1 > d) || (prev1 < prev2 && prev1 < d)) ? 1 : 0;
                long[] nxt = dfs(pos + 1, 1, d, prev1, 2, nt);
                count += nxt[0];
                waviness += nxt[1] + nxt[0] * add;
            }
        }

        if (!tight) {
            seen[pos][started][prev1][prev2][lenState] = true;
            cntMemo[pos][started][prev1][prev2][lenState] = count;
            wavMemo[pos][started][prev1][prev2][lenState] = waviness;
        }

        return new long[]{count, waviness};
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/)