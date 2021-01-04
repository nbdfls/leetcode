/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */
class Solution {
    public boolean isNumber(String s) {
        for(int i = 0;i<s.length();i++){
            char temp = s.charAt(i);
            if((temp<='d'&&temp>='a')||(temp<='z'&&temp>='f')||(temp>='A'&&temp<='D')||(temp>='F'&&temp<='Z')){
                return false;
            }
        }
    }
}

