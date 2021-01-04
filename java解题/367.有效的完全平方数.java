/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 0,end = num;
        while(start<=end){
            long mid = (start+end)/2;
            if(mid*mid==num){
                return true;
            }else if(mid*mid<num){
                start = mid+1 ;
            }else {
                end = mid-1 ;
            }
        }
        return false;
    }
}

