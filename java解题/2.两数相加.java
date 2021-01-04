import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    //     List<Integer> i1 = new ArrayList<>();
    //     List<Integer> i2 = new ArrayList<>();
    //     int temp1=0,temp2=0,k=1,temp1Index=0,temp2Index=0;
    //     while(l1!=null){
    //         i1.add(l1.val);
    //         l1 = l1.next;
    //     }
    //     while(l2!=null){
    //         i2.add(l2.val);
    //         l2 = l2.next;
    //     }
      
    //     while(temp1Index<i1.size()){
    //        temp1 = temp1 + i1.get(temp1Index)*k;
    //        k*=10;
    //     }
    //     k = 1;
    //     while(temp2Index<i2.size()){
    //         temp2 = temp2 + i2.get(temp2Index)*k;
    //         k*=10;
    //     }
    //     temp1 = temp1 + temp2;
    //     String temp =  String.valueOf(temp1);
    //     ListNode[] nodes = new ListNode[temp.length()];
    //     System.out.print(temp1+","+temp2+","+temp);
    //     for(int i = temp.length()-1,j = 0;j<temp.length();i--,j++){
    //         ListNode node = new ListNode(temp.charAt(i)-'0');
    //         nodes[j] = node;
    //     }
    //     for(int i =0;i<temp.length()-1;i++){
    //         nodes[i].next = nodes[i+1];
    //     }
    //     return  nodes[0];

    int carry = 0;
    ListNode p, dummy = new ListNode(0);
    p = dummy;
    while (l1 != null || l2 != null || carry != 0) {
        if (l1 != null) {
            carry += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carry += l2.val;
            l2 = l2.next;
        }
        p.next = new ListNode(carry%10);
        carry /= 10;
        p = p.next;
    }
    return dummy.next;
     }
}

