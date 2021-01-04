import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import java.util.Set;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int factor2 = 2,factor3 = 3,factor5=5;
        ugly[0] = 1;
        int i2=0,i3=0,i5=0;
        for(int i = 1;i<n;i++){
            int nextNum = Math.min(factor2,Math.min(factor3, factor5));
            ugly[i] = nextNum;
            if(nextNum==factor2){
                i2++;
                factor2 = ugly[i2]*2;
            }
            if(nextNum==factor3){
                i3++;
                factor3 = ugly[i3]*3;
            }
            if(nextNum==factor5){
                i5++;
                factor5 = ugly[i5]*5;
            }
        }
        return ugly[n-1];
    }
}

