import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
       List<Integer> re = new ArrayList<>();
       re = inOrderTree(root, re);
       System.out.print(re.size());
       if(re.size()<=1)return true;
       for(int i = 0;i<=re.size()-2;i++){
           if(re.get(i)>=re.get(i+1)){
               return false;
           }
       }
       return true;
    }
    public List<Integer> inOrderTree(TreeNode root,List<Integer> re){
       
        if(root.left!=null)
        {
            inOrderTree(root.left,re);
        }
        if(root!=null){
            re.add(root.val);
        }

        if(root.right!=null){
            inOrderTree(root.right, re);
        }
        return re;
    }
}

