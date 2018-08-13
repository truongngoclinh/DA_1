package com.boiboi.ds.w1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Quick find: O(n)
 *
 * @author linhtruong
 * @date 4/11/18 - 11:28.
 * @organization VED
 */

public class QuickFind extends UF {
    protected int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public void ids() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }

        System.out.println("");
    }

    @Override
    public void result() {
        System.out.println("Connected groups:");
        HashMap<Integer, String> tree = new HashMap<>();
        HashSet<Integer> roots = new HashSet<>();

        for (int i = 0; i < id.length; i++) {
            System.out.print(i + " - " + id[i] + " ");
            roots.add(id[i]);
        }
        System.out.println("\n---------");

        Iterator<Integer> iterator = roots.iterator();
        while (iterator.hasNext()) {
            int tmp = iterator.next();
            for (int i = 0; i < id.length; i++) {
                if (id[i] == tmp) {
                    String treeNodes = tree.get(tmp) == null ? "" : tree.get(tmp) + " ";
                    tree.put(tmp, treeNodes + i);
                }
            }
        }

        for (Integer key : tree.keySet()) {
            System.out.print(tree.get(key) + "\n");
        }
    }
}
