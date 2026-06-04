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
