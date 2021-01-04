/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */
class Solution {
    public int trailingZeroes(int n) {
       int re = 0;
       while(n>0){
           re = n/5+re;
           n=n/5;
       }
       return re;
    }
}

