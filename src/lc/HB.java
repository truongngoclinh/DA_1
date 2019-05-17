package lc;

import java.util.ArrayList;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 5/6/19 - 08:40.
 * @organization VED
 */

public class HB {
    public int solution() {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)

        return 0;
    }

    class MyHashSet {
        ArrayList<Integer> value;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            value = new ArrayList<>();
        }

        public void add(int key) {
            if (!contains(key)) {
                value.add(hash(key),key);
            }
        }

        public void remove(int key) {
            if (value.size() > hash(key)) {
                value.remove(hash(key));
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            if (value.size() > hash(key) && value.get(hash(key)) == key)
                return true;
            return false;
        }

        private int hash(int value) {
           return value;
        }
    }

}
