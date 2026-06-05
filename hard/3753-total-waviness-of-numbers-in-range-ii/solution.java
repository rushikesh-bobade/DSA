                waviness += nxt[1];
            } else {
                int add = ((prev1 > prev2 && prev1 > d) || (prev1 < prev2 && prev1 < d)) ? 1 : 0;
                long[] nxt = dfs(pos + 1, 1, d, prev1, 2, nt);
                count += nxt[0];
                waviness += nxt[1] + nxt[0] * add;
            }
        }

        if (!tight) {
            seen[pos][started][prev1][prev2][lenState] = true;
            cntMemo[pos][started][prev1][prev2][lenState] = count;
            wavMemo[pos][started][prev1][prev2][lenState] = waviness;
        }

        return new long[]{count, waviness};
    }
}
