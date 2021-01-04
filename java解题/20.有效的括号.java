import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> kuoHao = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                kuoHao.push(')');
            }else if(s.charAt(i)=='{'){
                kuoHao.push('}');
            }else if(s.charAt(i)=='['){
                kuoHao.push(']');
            }else if(kuoHao.empty()||kuoHao.pop()!=s.charAt(i)){
                return false;
            }
        }
        if(kuoHao.empty()){
            return true;
        }else {
            return false;
        }
        
        

        
    }
}

