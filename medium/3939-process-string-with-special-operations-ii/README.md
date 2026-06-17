# Process String With Special Operations Ii

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** 32 ms (beats 42.86%)  
**Memory:** 47.5 MB (beats 97.74%)  
**Submitted:** 2026-06-17T21:00:46.933Z  

```java
class Solution {
    public char processStr(String s, long k) {

        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = len[i] + 1;
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '#') {
                len[i + 1] = len[i] * 2;
            } else { // %
                len[i + 1] = len[i];
            }
        }

        long finalLen = len[n];

        if (k >= finalLen) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                if (k == len[i + 1] - 1) {
                    return ch;
                }

            } else if (ch == '#') {

                long oldLen = len[i];

                if (k >= oldLen) {
                    k -= oldLen;
                }

            } else if (ch == '%') {

                long curLen = len[i + 1];
                k = curLen - 1 - k;

            } else { // '*'
                // nothing to do
            }
        }

        return '.';
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/process-string-with-special-operations-ii/)