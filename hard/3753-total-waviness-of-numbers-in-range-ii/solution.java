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