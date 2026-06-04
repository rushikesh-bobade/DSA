class Solution {
    private char[] s;
    private long[][][][] memoCnt;
    private long[][][][] memoSum;
    private boolean[][][][] seen;

    public int totalWaviness(int num1, int num2) {
        long ans = solve(num2) - solve(num1 - 1);
        return (int) ans;
    }

    private long solve(int n) {
        if (n <= 0) return 0;
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memoCnt = new long[m + 1][3][11][11];
        memoSum = new long[m + 1][3][11][11];
        seen = new boolean[m + 1][3][11][11];
        return dfs(0, 0, 10, 10, true)[1];
    }

    private long[] dfs(int pos, int lenState, int prev2, int prev1, boolean tight) {
        if (pos == s.length) {
            return new long[]{1, 0};
        }

        if (!tight && seen[pos][lenState][prev2][prev1]) {
            return new long[]{
                memoCnt[pos][lenState][prev2][prev1],
                memoSum[pos][lenState][prev2][prev1]
            };
        }

        long count = 0;
        long sum = 0;
        int limit = tight ? s[pos] - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            boolean nt = tight && d == limit;

            if (lenState == 0) {
                if (d == 0) {
                    long[] res = dfs(pos + 1, 0, 10, 10, nt);
                    count += res[0];
                    sum += res[1];
                } else {
                    long[] res = dfs(pos + 1, 1, 10, d, nt);
                    count += res[0];
                    sum += res[1];
                }
            } else if (lenState == 1) {
                long[] res = dfs(pos + 1, 2, prev1, d, nt);
                count += res[0];
                sum += res[1];
            } else {
                int add = ((prev1 > prev2 && prev1 > d) || (prev1 < prev2 && prev1 < d)) ? 1 : 0;
                long[] res = dfs(pos + 1, 2, prev1, d, nt);
                count += res[0];
                sum += res[1] + (long) add * res[0];
            }
        }

        if (!tight) {
            seen[pos][lenState][prev2][prev1] = true;
            memoCnt[pos][lenState][prev2][prev1] = count;
            memoSum[pos][lenState][prev2][prev1] = sum;
        }

        return new long[]{count, sum};
    }
}