# Longest Substring Without Repeating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** C++  
**Runtime:** 10 ms (beats 51.72%)  
**Memory:** 14.3 MB (beats 28.93%)  
**Submitted:** 2026-06-04T09:53:57.731Z  

```cpp
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char>mp;
        int maxLong=0;
        int start=0;

        for(int i=0;i<s.length();i++){

            while(mp.find(s[i])!=mp.end()){
                mp.erase(s[start]);
                start++;
            }

            mp.insert(s[i]);        

            maxLong=max(maxLong,i-start+1);
        }
        return maxLong;
    }
};

```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)