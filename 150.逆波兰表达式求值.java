import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numContainer = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            switch (temp) {
            case "+": {
                int num1 = numContainer.pop();
                int num2 = numContainer.pop();
                result = num1 + num2;
                numContainer.push(result);
                break;
            }
            case "-": {
                int num1 = numContainer.pop();
                int num2 = numContainer.pop();
                result = num2 - num1;
                numContainer.push(result);
                break;
            }
            case "*": {
                int num1 = numContainer.pop();
                int num2 = numContainer.pop();
                result = num1 * num2;
                numContainer.push(result);
                break;
            }
            case "/": {
                int num1 = numContainer.pop();
                int num2 = numContainer.pop();
                result = num2 / num1;
                numContainer.push(result);
                break;
            }
            default: {
                numContainer.push(Integer.parseInt(tokens[i]));
            }
            }
        }
        result = numContainer.pop();
        return result;
    }
}
