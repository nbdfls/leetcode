/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */
class Solution {
    public int countPrimes(int n) {
        int re = 0;
        boolean p = true;
        if(n==2) return 0;
        if(n==3) return 1;
        for(int i = 2;i<n;i++){
            
            if(n>3){
                
           for(int j = 2;j<=Math.sqrt(i);j++){
               if(i%j==0){
                p = false;
               }  
           }
           if(p){
               re++;
           }
           p = true;

        }
        }
        return re;
    }
 

}


