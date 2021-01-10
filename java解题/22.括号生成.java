/*
 * @Author: your name
 * @Date: 2021-01-09 15:29:46
 * @LastEditTime: 2021-01-09 16:27:03
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /.leetcode/java解题/22.括号生成.java
 */
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        if(n==0){
            return list;
        }
        dfs("", n,n, list);
        return list;
    }
    /**
     * @description: 深度优先遍历，生成递归树并剪枝保证结果正确
     * @param {String} curStr：递归结果
     * @param {int} left：左括号还剩几个
     * @param {int} right：右括号还剩几个
     * @param {List<String>} res：结果集合
     * @return {*}
     */
    public void dfs(String curStr,int left,int right, List<String> res){
        // 当遍历到叶子结点，终止条件
        if(left == 0 && right ==0){
            res.add(curStr);
            return;
        }
        // 剪枝，左括号可以使用个数严格大于右括号，剪枝
        if(left > right){
            return;
        }
        // 深度优先搜索，可以看出来，先进入left一直到底然后才考虑right
        if(left > 0){
            dfs(curStr+"(", left-1 , right, res);
        }
        if(right >0){
            dfs(curStr+")",left,right-1,res);
        }
    }
}
// @lc code=end

