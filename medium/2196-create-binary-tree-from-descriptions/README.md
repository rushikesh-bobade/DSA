# Create Binary Tree From Descriptions

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,


	If isLefti == 1, then childi is the left child of parenti.
	If isLefti == 0, then childi is the right child of parenti.


Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

 
Example 1:

Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.


Example 2:

Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.


 
Constraints:


	1 <= descriptions.length <= 104
	descriptions[i].length == 3
	1 <= parenti, childi <= 105
	0 <= isLefti <= 1
	The binary tree described by descriptions is valid.

## Solution

**Language:** Java  
**Runtime:** 68 ms (beats 51.16%)  
**Memory:** 86.2 MB (beats 50.74%)  
**Submitted:** 2026-06-07T14:02:16.041Z  

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> mpp = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < descriptions.length; i++) {
            int[] d = descriptions[i];
            int parent = d[0], child = d[1], isLeft = d[2];

            mpp.putIfAbsent(parent, new TreeNode(parent));
            mpp.putIfAbsent(child, new TreeNode(child));

            if (isLeft == 1) {
                mpp.get(parent).left = mpp.get(child);
            } else {
                mpp.get(parent).right = mpp.get(child);
            }
            set.add(child);
        }

        for (int[] d : descriptions) {
            if (!set.contains(d[0])) {
                return mpp.get(d[0]);
            }
        }

        return null;

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/create-binary-tree-from-descriptions/)