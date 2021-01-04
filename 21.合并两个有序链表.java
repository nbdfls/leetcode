/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        if(l2.val>l1.val){
            res.val = l1.val;
            l1 = l1.next;
        }else{
            res.val = l2.val;
            l2 = l2.next;
        }
        ListNode temp = new ListNode();
        res.next = temp;
        while(true){
            temp=getGreater(l1,l2);
            temp.next = temp1;
            if(temp==l1){
                l1 = l1.next;
            }else{
                l2 = l2.next;
            }
        }
    }
    public ListNode getGreater(ListNode l1,ListNode l2){
        if(l1.val>l2.val){
            return l1;
        }else{
            return l2;
        }
    }
}
// @lc code=end

