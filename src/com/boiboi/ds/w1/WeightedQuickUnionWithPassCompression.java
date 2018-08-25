package com.boiboi.ds.w1;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/11/18 - 16:07.
 * @organization VED
 */

public class WeightedQuickUnionWithPassCompression extends WeightedQuickUnion {
    public WeightedQuickUnionWithPassCompression(int N) {
        super(N);
    }

    @Override
    protected int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // points node to its grandparents node
            i = id[i];
        }

        return i;
    }
}
