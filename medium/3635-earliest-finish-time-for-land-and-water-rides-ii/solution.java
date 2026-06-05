import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        long ans = Math.min(
            solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur, int[] secondStart, int[] secondDur) {
        int n = firstStart.length;
        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        long[] prefixMinDur = new long[m];
        long[] suffixMinEnd = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
            prefixMinDur[i] = rides[i][1];
            if (i > 0) {
                prefixMinDur[i] = Math.min(prefixMinDur[i], prefixMinDur[i - 1]);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            suffixMinEnd[i] = (long) rides[i][0] + rides[i][1];
            if (i + 1 < m) {
                suffixMinEnd[i] = Math.min(suffixMinEnd[i], suffixMinEnd[i + 1]);
            }
        }

        long res = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long finish = (long) firstStart[i] + firstDur[i];

            int idx = upperBound(starts, (int) finish) - 1;

            long best = Long.MAX_VALUE;

            if (idx >= 0) {
                best = Math.min(best, finish + prefixMinDur[idx]);
            }

            if (idx + 1 < m) {
                best = Math.min(best, suffixMinEnd[idx + 1]);
            }

            res = Math.min(res, best);
        }

        return res;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}