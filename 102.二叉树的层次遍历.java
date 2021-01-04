import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rootList  = new ArrayList<>();;
        if(root==null)
        return rootList;
           rootList = levelOrderTemp(root, rootList, 0);
        return rootList;
    }
    public List<List<Integer>> levelOrderTemp(TreeNode root,List<List<Integer>> levelLists,int level ){
        if(levelLists.size()<=level){
            ArrayList<Integer> leveList = new ArrayList<>();
            levelLists.add(leveList);
        }
        ArrayList<Integer> list = (ArrayList<Integer>) levelLists.get(level);
        list.add(root.val);
        if(root.left!=null){
            levelOrderTemp(root.left, levelLists, level+1);
        }
        if(root.right!=null){
            levelOrderTemp(root .right, levelLists, level+1);

        }
        return levelLists;
    }
}

