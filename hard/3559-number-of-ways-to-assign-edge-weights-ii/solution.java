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