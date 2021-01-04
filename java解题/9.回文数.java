/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */
class Solution {
    public boolean isPalindrome(int x) {
      if(x<0|| (x!=0 && x%10==0) ) 
      {System.out.println(1);
        return false;}
    int temp = x;
      int re = 0;
      while(x>0){
        re = re*10 + x%10;
        x/=10;
      }
      System.out.println(re);
      if(re==temp) return true;
      return false;
    }
}

