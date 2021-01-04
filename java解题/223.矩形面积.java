/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        int overlap = 0;
        int sq1 = (D-B)*(C-A),sq2 = (H-F)*(G-E);
        if(left<right&&bottom<top){
             overlap = Math.abs((right-left)*(top-bottom));

        }
        return sq1+sq2-overlap;

    }
}

