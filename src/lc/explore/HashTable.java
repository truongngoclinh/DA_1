package lc.explore;

import java.util.*;

public class HashTable {
    public int solution() {
/*
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] result = intersection(nums1, nums2);

        for (int i : result) {
            System.out.print(i + " ");
        }
*/

/*
        System.out.println("Happy number? 7: " + isHappy(7));
        System.out.println("Happy number? 2: " + isHappy(2));
        System.out.println("Happy number? 19: " + isHappy(19));
*/

//        int i[] = {2, 7, 11, 15};
//        int t = 9;
//        int i[] = {3, 3};
//        int t = 6;
//        int r[] = twoSum(i, t);
//        for (int j : r) {
//            System.out.print(j + " ");
//        }

//        String s = "paper", t = "title";
//        System.out.print(isIsomorphic(s, t) && isIsomorphic(t, s));
//        String s1[] = {"Shogun", "Tapioca Express", "Burger King", "KFC"},
//                s2[] = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
//        System.out.print(findRestaurant(s1, s2));

//        String s = "loveleetcode";
//        System.out.print(firstUniqChar(s));
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] r = intersection(nums1, nums2);
        for (Integer i : r) {
            System.out.print(i + " ");
        }

        return 0;
    }

    // INTERSECTIONS OF TWO ARRAYS
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet result = new HashSet();
        HashSet set = new HashSet();
        if (nums1.length < nums2.length) {
            for (int i = 0; i < nums2.length; i++) {
                set.add(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                if (set.contains(nums1[i])) result.add(nums1[i]);
            }
        } else {
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (set.contains(nums2[i])) result.add(nums2[i]);
            }
        }

        int i = 0;
        int resultInIntArray[] = new int[result.size()];
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            resultInIntArray[i] = Integer.parseInt(iterator.next().toString());
            i++;
        }

        return resultInIntArray;
    }

    // HAPPY NUMBER
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;

        return checkHappy(n, set);
    }

    private boolean checkHappy(int n, Set set) {
        int sum = 0;
        if (set.contains(n)) return false;
        set.add(n);
        while (true) {
            sum += Math.pow(n % 10, 2);
            if (n < 10) break;
            n = n / 10;
        }

        if (sum == 1) return true;
        return checkHappy(sum, set);
    }

    // TWO SUM
    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            ArrayList<Integer> key = map.getOrDefault(nums[i], new ArrayList<>());
//            key.add(i);
//            map.put(nums[i], key);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int j = target - nums[i];
//            if (map.containsKey(j)) {
//                result[0] = i;
//                ArrayList<Integer> key = map.get(j);
//                for (Integer ki : key) {
//                    if (ki != i) {
//                        result[1] = ki;
//                        return result;
//                    }
//                }
//            }
//        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j) && map.get(j) != i) {
                return new int[]{i, map.get(nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }

    // ISOMORPHIC STRING
    public boolean isIsomorphic(String s, String t) {/*
        int l = s.length();
        char a[] = s.toCharArray();
        char a2[] = t.toCharArray();
        Map<Character, ArrayList<Integer>> map = new HashMap<>(l);
        for (int i = 0; i < l; i++) {
            ArrayList<Integer> key = map.getOrDefault(a[i], new ArrayList<>());
            key.add(i);
            map.put(a[i], key);
        }

        for (ArrayList<Integer> value : map.values()) {
            char c = a2[value.get(0)];
            if (value.size() > 1) {
                for (int i = 1; i < value.size(); i++) {
                    if (c != a2[value.get(i)]) {
                        return false;
                    }
                }
            }
        }*/
/*
        int l = s.length();
        int si[] = new int[256];
        int ti[] = new int[256];
        char sa[] = s.toCharArray();
        char ta[] = t.toCharArray();

        for (int i = 0; i < l; i++) {
            char sc = sa[i];
            char tc = ta[i];
            if (si[sc] == 0 && ti[tc] == 0) {
                si[sc] = tc;
                ti[tc] = sc;
            } else {
                if (si[sc] != tc || ti[tc] != sc) {
                    return false;
                }
            }
        }*/


        int l = s.length();
        int si[] = new int[256];
        int ti[] = new int[256];
        char sa[] = s.toCharArray();
        char ta[] = t.toCharArray();

        for (int i = 0; i < l; i++) {
            char sc = sa[i];
            char tc = ta[i];
            if (si[sc] != ti[tc]) return false;
            si[sc] = i + 1;
            ti[tc] = i + 1;
        }

        return true;
    }

    //  MINIMUM INDEX SUM OF TWO LIST
    public String[] findRestaurant(String[] list1, String[] list2) {
        int l1 = list1.length, l2 = list2.length;
        Map<String, Integer> map = new HashMap<>(l1);
        for (int i = 0; i < l1; i++) {
            map.put(list1[i], i);
        }

        int sum = 1000 * 2;
        Map<Integer, ArrayList<String>> rMap = new HashMap<>();
        for (int i = 0; i < l2; i++) {
            String str = list2[i];
            if (map.containsKey(str) && map.get(str) + i <= sum) {
                sum = map.get(str) + i;
                ArrayList<String> values = rMap.getOrDefault(sum, new ArrayList<>());
                values.add(str);
                rMap.put(sum, values);
            }
        }

        int i = 0;
        ArrayList<String> ra = rMap.get(sum);
        String[] r = new String[ra.size()];
        for (String str : ra) {
            r[i] = str;
            i++;
        }

        return r;
    }


    // FIRST UNIQUE CHAR
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            int v = map.getOrDefault(c, -1);
            map.put(c, ++v);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 0) {
                return s.indexOf(e.getKey());
            }
        }

        return -1;
    }

    // INTERSECTION OF TWO ARRAYS
    public int[] intersect(int[] nums1, int[] nums2) {
        return new int[2];
    }
}
