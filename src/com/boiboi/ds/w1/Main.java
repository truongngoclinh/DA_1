package com.boiboi.ds.w1;

import utils.FileUtils;

import java.util.Scanner;

/**
 * UF models
 *
 * @author linhtruong
 * @date 3/27/18 - 14:44.
 * @organization VED
 */

public class Main {
    public static void main(String args[]) {
        Scanner scanner = FileUtils.readFile("w1/input");
        int N = Integer.valueOf(scanner.next());

        long t = System.currentTimeMillis();
        UF uf;
        // uf = new QuickFind(N);
        // uf = new QuickUnion(N);
        // uf = new WeightedQuickUnion(N);
        uf = new WeightedQuickUnionWithPassCompression(N);

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            uf.union(p, q);
        }
        System.out.println("Running time: " + (System.currentTimeMillis() - t));

        uf.ids();

        System.out.println("isConnected: (1,9) " + uf.isConnected(1, 9));
        System.out.println("isConnected: (0,4) " + uf.isConnected(0, 4));
        System.out.println("isConnected: (2,6) " + uf.isConnected(2, 6));
        System.out.println("isConnected: (7,0) " + uf.isConnected(7, 0));
        System.out.println("isConnected: (1,7) " + uf.isConnected(1, 7));
    }
}
