/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start

  //Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

// 分治排序 算法  两两分治
class Solution {
    // public ListNode mergeKLists(ListNode[] lists) {
    //     ListNode ans = null;
    //     if(lists.length==0){
    //         return ans;
    //     }
    //     for(int i = 0;i<lists.length;i++){
    //         ans = margeTwoList(ans, lists[i]);
    //     }
    //     return ans;
        
    // }
    public ListNode margeTwoList(ListNode node1,ListNode node2){
        ListNode prehead = new ListNode();
        ListNode temp = prehead;
        while(node1!=null&&node2!=null)
        {
            if(node1.val>=node2.val){
                temp.next = node2;
                temp = temp.next;
                node2 = node2.next;
            }
            else{
                temp.next = node1;
                temp = temp.next;
                node1 = node1.next;
            }
        }
        temp.next = (node1!=null)?node1:node2;
        return prehead.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (l+r)>>1;
        return margeTwoList(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    
}
// @lc code=end

