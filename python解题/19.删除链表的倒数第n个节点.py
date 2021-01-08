#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第N个节点

# 双指针还能这么用！！！ 根据fast和slow有恒定的位置差n，
# 当fast到链表末端，slow自然到达倒数第n个位置

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        fast = slow = head
        for _ in range(n):
            fast = fast.next
        if not fast:
            return head.next
        while fast.next:
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        return head
        # size = 0
        # result = head
        # while(head):
        #     head = head.next
        #     size+=1
        # if(size == 1):
        #     return None
        # head = result
        # n = size - n
        # print(n)
        # if(n==0):  return head.next
        # for i in range(0,n):
        #     temp = head
        #     head = head.next
        #     if(i+1==n):
        #         if(head.next!=None):
        #             temp.next=head.next
        #         else:
        #             temp.next=None
        #         break
        # return result


                
# @lc code=end

