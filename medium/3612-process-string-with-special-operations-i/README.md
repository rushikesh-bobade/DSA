# Process String with Special Operations I

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.

Build a new string result by processing s according to the following rules from left to right:


	If the letter is a lowercase English letter append it to result.
	A '*' removes the last character from result, if it exists.
	A '#' duplicates the current result and appends it to itself.
	A '%' reverses the current result.


Return the final string result after processing all characters in s.

 
Example 1:


Input: s = "a#b%*"

Output: "ba"

Explanation:

is[i]OperationCurrent result0'a'Append 'a'"a"1'#'Duplicate result"aa"2'b'Append 'b'"aab"3'%'Reverse result"baa"4'*'Remove the last character"ba"

Thus, the final result is "ba".


Example 2:


Input: s = "z*#"

Output: ""

Explanation:

is[i]OperationCurrent result0'z'Append 'z'"z"1'*'Remove the last character""2'#'Duplicate the string""

Thus, the final result is "".


 
Constraints:


	1 <= s.length <= 20
	s consists of only lowercase English letters and special characters *, #, and %.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 76.47%)  
**Memory:** 54.9 MB (beats 88.24%)  
**Submitted:** 2026-06-16T15:45:56.246Z  

```java
class Solution {
    public String processStr(String s) {
        StringBuilder result=new StringBuilder();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
 
            if(ch=='#'){
                result.append(result);
            }else if(ch=='%'){
                result.reverse();
            }else if(ch=='*'){
                if(result.length()>0){
                    result.deleteCharAt(result.length()-1);
                }
            }else{
                result.append(ch);
            }
        }

        String ans=result.toString();
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/process-string-with-special-operations-i/)