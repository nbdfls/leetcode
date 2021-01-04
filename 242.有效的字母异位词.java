import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */
class Solution {
    public boolean isAnagram(String s, String t) {

        char[] cs = s.toCharArray();
        char[] ct = s.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);
        s = String.valueOf(cs);
        t = String.valueOf(ct);


        if (s == t) {
            return true;
        }
        return false;
    }
}
