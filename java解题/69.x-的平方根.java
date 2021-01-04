/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */
class Solution {
    public int mySqrt(long x) {
        if(x==1){
            return 1;
        }
        if(x<1){
            return 0;
        }

        long start = 0, end = x;

        long mid= end/2;
        while(start<end){
             mid = (start+end)/2;
             if(mid*mid>x){
                 if(end == mid){
                     return (int) (end - 1);
                 }
                 end = mid;
             }else if(mid*mid<x){
                 if(start == mid){
                     return (int) start;
                 }
                 start = mid;
             }else{
                 return (int) mid;
             }
        }
        return (int) mid;
    }
}

