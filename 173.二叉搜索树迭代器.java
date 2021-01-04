import java.util.Stack;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class BSTIterator {
    Stack<TreeNode> con = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = con.pop();
        pushAll(temp.right);
        return temp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !con.isEmpty();
    }

    public void pushAll(TreeNode root) {
       
        while (root!= null) {
            con.push(root);
            root = root.left;

        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
