# Number of Ways to Assign Edge Weights II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi.

Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.

The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.

You are given a 2D integer array queries. For each queries[i] = [ui, vi], determine the number of ways to assign weights to edges in the path such that the cost of the path between ui and vi is odd.

Return an array answer, where answer[i] is the number of valid assignments for queries[i].

Since the answer may be large, apply modulo 109 + 7 to each answer[i].

Note: For each query, disregard all edges not in the path between node ui and vi.

 
Example 1:




Input: edges = [[1,2]], queries = [[1,1],[1,2]]

Output: [0,1]

Explanation:


	Query [1,1]: The path from Node 1 to itself consists of no edges, so the cost is 0. Thus, the number of valid assignments is 0.
	Query [1,2]: The path from Node 1 to Node 2 consists of one edge (1 → 2). Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.



Example 2:




Input: edges = [[1,2],[1,3],[3,4],[3,5]], queries = [[1,4],[3,4],[2,5]]

Output: [2,1,4]

Explanation:


	Query [1,4]: The path from Node 1 to Node 4 consists of two edges (1 → 3 and 3 → 4). Assigning weights (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2.
	Query [3,4]: The path from Node 3 to Node 4 consists of one edge (3 → 4). Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.
	Query [2,5]: The path from Node 2 to Node 5 consists of three edges (2 → 1, 1 → 3, and 3 → 5). Assigning (1,2,2), (2,1,2), (2,2,1), or (1,1,1) makes the cost odd. Thus, the number of valid assignments is 4.



 
Constraints:


	2 <= n <= 105
	edges.length == n - 1
	edges[i] == [ui, vi]
	1 <= queries.length <= 105
	queries[i] == [ui, vi]
	1 <= ui, vi <= n
	edges represents a valid tree.

## Solution

**Language:** Java  
**Runtime:** 52 ms (beats 100.00%)  
**Memory:** 275 MB (beats 100.00%)  
**Submitted:** 2026-06-12T07:56:09.090Z  

```java
class Solution {
    static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int[] deg = new int[n + 1];
        for (int[] e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;
        }

        int[][] g = new int[n + 1][];
        for (int i = 1; i <= n; i++) g[i] = new int[deg[i]];
        int[] idx = new int[n + 1];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u][idx[u]++] = v;
            g[v][idx[v]++] = u;
        }

        int log = 1;
        while ((1 << log) <= n) log++;

        int[][] up = new int[log][n + 1];
        int[] depth = new int[n + 1];
        int[] q = new int[n];
        int head = 0, tail = 0;

        q[tail++] = 1;
        up[0][1] = 0;

        while (head < tail) {
            int u = q[head++];
            for (int v : g[u]) {
                if (v == up[0][u]) continue;
                up[0][v] = u;
                depth[v] = depth[u] + 1;
                q[tail++] = v;
            }
        }

        for (int k = 1; k < log; k++) {
            for (int i = 1; i <= n; i++) {
                int p = up[k - 1][i];
                up[k][i] = p == 0 ? 0 : up[k - 1][p];
            }
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int a = u, b = v;

            if (depth[a] < depth[b]) {
                int t = a;
                a = b;
                b = t;
            }

            int diff = depth[a] - depth[b];
            for (int k = 0; k < log; k++) {
                if (((diff >> k) & 1) != 0) a = up[k][a];
            }

            int lca;
            if (a == b) {
                lca = a;
            } else {
                for (int k = log - 1; k >= 0; k--) {
                    if (up[k][a] != up[k][b]) {
                        a = up[k][a];
                        b = up[k][b];
                    }
                }
                lca = up[0][a];
            }

            int len = depth[u] + depth[v] - 2 * depth[lca];
            ans[i] = len == 0 ? 0 : (int) pow2[len - 1];
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/)