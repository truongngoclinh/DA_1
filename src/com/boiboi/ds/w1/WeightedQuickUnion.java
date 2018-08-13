package com.boiboi.ds.w1;

/**
 * assign smaller tree to root of bigger tree: optimize calculate size by just only tall of the tree?
 *
 * @author linhtruong
 * @date 4/11/18 - 15:35.
 * @organization VED
 */

public class WeightedQuickUnion extends QuickUnion {
    private int[] size;

    public WeightedQuickUnion(int N) {
        super(N);

        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

    @Override
    public void result() {
        super.result();
    }
}
