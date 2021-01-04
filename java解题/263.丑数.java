/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */
class Solution {
    public boolean isUgly(int num) {
        if(num==1) return true;
        if(num ==0) return false;
        while(num%2==0||num%3==0||num%5==0){
            if(num%2==0){
                num/=2;
            }else if(num%3==0){
                num/=3;
            }else if(num%5==0){
                num/=5;
            }
        }
        if(num==1){
            return true;
        }else {
            return false;
        }
    }
}

