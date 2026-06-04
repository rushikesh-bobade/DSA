# Reverse Integer

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 
Example 1:

Input: x = 123
Output: 321


Example 2:

Input: x = -123
Output: -321


Example 3:

Input: x = 120
Output: 21


 
Constraints:


	-231 <= x <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.98%)  
**Memory:** 42.4 MB (beats 89.43%)  
**Submitted:** 2026-06-04T09:27:58.742Z  

```java
class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int r = 0;
        while (x != 0) {
            int d = x % 10;
            if (r > (Integer.MAX_VALUE - d) / 10) return 0;
            r = r * 10 + d;
            x /= 10;
        }
        return r * sign;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/reverse-integer/)