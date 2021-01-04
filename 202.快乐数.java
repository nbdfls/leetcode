import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */
class Solution {
    public boolean isHappy(int n) {
        List<Integer> li = new ArrayList<>();
        li.add(n);
        while(n!=1){
            int re = 0;
            while(n!=0){
                re = (int) Math.pow(n % 10, 2)+re;
                n /=10;
            }
            if(li.contains(re)){
                return false;
            }else{
                li.add(re);
                n = re;
            }
        }
        return true;
        
    }
}

