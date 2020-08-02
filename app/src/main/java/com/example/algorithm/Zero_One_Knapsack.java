package com.example.algorithm;

public class Zero_One_Knapsack {
    public String solve(Integer[] wt, Integer[] val, int W, int N) {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                int m1 = m[i - 1][j];
                int m2 = NEGATIVE_INFINITY;
                if (j >= wt[i])
                    m2 = m[i - 1][j - wt[i]] + val[i];
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w] != 0) {
                selected[n] = 1;
                w = w - wt[n];
            } else
                selected[n] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (selected[i] == 1) {
                sb.append(val[i]);
                sb.append(" ");
            }
        }

        String s = sb.toString();
        return "\nItems with weight " + s + "are selected by knapsack algorithm.";
    }
}
