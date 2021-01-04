/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * 
 */
#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:

    vector<int> v;
    vector<int> preorderTraversal(TreeNode* root) {
        if(root==nullptr)
        return v;

        preorder(root);
        return v;
    }
    void preorder(TreeNode* root){
        if(root==nullptr){
            return ;
        }
        v.push_back(root->val);
        if(root->left!=nullptr)
        preorder(root->left);
        if(root->right!=nullptr)
        preorder(root->right);
    }
};

