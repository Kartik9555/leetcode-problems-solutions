/*
*
* Given the head of a singly linked list, reverse the list, and return the reversed list.
*
* Example 1:
* Input: head = [1,2,3,4,5]
* Output: [5,4,3,2,1]
*
* Input: head = [1,2]
* Output: [2,1]
*
* Example 3:
* Input: head = []
* Output: []
*
* Constraints:
* The number of nodes in the list is the range [0, 5000].
* -5000 <= Node.val <= 5000
*
* Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
package com.leetcode.practice;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        while(head!=null){
            ListNode start = head;
            head = head.next;
            if(reverseHead == null){
                start.next = null;
                reverseHead = start;
            } else {
                start.next = reverseHead;
                reverseHead = start;
            }

        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode head = createList(new int[]{1,2,3,4,5});
        traverserNode(head);
        System.out.println("");
        traverserNode(reverseList(head));

        ListNode head1 = createList(new int[]{1,2});
        System.out.println("");
        traverserNode(head1);
        System.out.println("");
        traverserNode(reverseList(head1));
    }

    public static void traverserNode(ListNode head) {
        while(head != null){
            System.out.print(head.val + (head.next == null ? "" : "-->"));
            head = head.next;
        }
    }

    public static ListNode createList(int[] array){
        ListNode head = null;
        ListNode start = null;
        for (int no : array){
            ListNode node = new ListNode(no);
            if (start == null) {
                head = node;
            } else {
                start.next = node;
            }
            start = node;
        }
        return head;
    }
}