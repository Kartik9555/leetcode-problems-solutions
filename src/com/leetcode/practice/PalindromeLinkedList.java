/*
* Given the head of a singly linked list, return true if it is a palindrome.
* Example 1:
* 1 -> 2 -> 2 -> 2 -> 1
* Input: head = [1,2,2,1]
* Output: true
* Example 2:
* 1 -> 2
* Input: head = [1,2]
* Output: false
* Constraints:
* The number of nodes in the list is in the range [1, 105].
* 0 <= Node.val <= 9
*/

package com.leetcode.practice;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode start = head;
        String str = "";
        while(start != null){
            str += start.val;
            start = start.next;
        }
        String reverse = new StringBuffer(str).reverse().toString();
        return reverse.equalsIgnoreCase(str);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(createList(new int[]{1,2})));
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


