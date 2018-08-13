package com.boiboi.ds.w1;

/**
 *
 *
 * @author linhtruong
 * @date 4/11/18 - 14:14.
 * @organization VED
 */

public class QuickUnion extends QuickFind {
    public QuickUnion(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);

        id[pid] = qid;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }


    protected int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }

        return i;
    }
}
