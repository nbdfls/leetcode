import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        int i = s.length - 1;
        for (; i >= 0; i--) {
            for (int j = g.length - 1; j >= 0; j--) {
                if (s[i] >= g[j]) {
                    g[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        for (int m = 0; m <= g.length - 1; m++) {
            System.out.print(g[m]);
            if (g[m] == Integer.MAX_VALUE) {
                sum++;
            }
        }
        return sum;
    }

   

}
