import java.util.List;

/*
 * @Author: lishui fan
 * @Date: 2021-02-10 10:36:19
 * @LastEditors: your name
 * @LastEditTime: 2021-03-10 14:43:49
 * @Description: file content
 *
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
import java.util.ArrayList;
class Solution {
    
    //     public static void main(String[] args){
    //     Solution79 s = new Solution79();
    //     char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    //     String word = "ABCCED";
    //     s.exist(board,word);
        
    // }
    public boolean exist(char[][] board, String word) {
        Character begin = word.charAt(0);
        int m = board.length;
        int n = board[0].length;
    //   List<Boolean> list = new ArrayList<>(); 
        boolean[][] used = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == begin){
                   boolean  flag = dfs(board, used, word, 0, i, j);
                    if(flag) return true;
                }
            }
        }
        return false;

    }
    public boolean dfs(char[][] board,boolean[][] used, String word,int index,int row,int col){   
        boolean re = false;
        if(index == word.length()-1){
            //flag[0] = true;
                return true;
            }
        
        
            used[row][col] = true;
            if(row+1<board.length&&used[row+1][col]==false&&word.charAt(index+1)==board[row+1][col]){
                re = re||dfs(board,used, word, index+1, row+1, col);
            }
            if(row-1>=0&&used[row-1][col]==false&&word.charAt(index+1)==board[row-1][col]){
                re = re||dfs(board,used, word, index+1, row-1, col);
            }
            if(col+1<board[0].length&&used[row][col+1]==false&&word.charAt(index+1)==board[row][col+1]){
                re = re||dfs(board,used, word, index+1, row, col+1);
            }
            if(col-1>=0&&used[row][col-1]==false&&word.charAt(index+1)==board[row][col-1]){
                re = re||dfs(board,used, word, index+1, row, col-1);
            }
            used[row][col] = false;
        
        return re;
    }
}
// @lc code=end

