/*
* Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
* Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].
* Example 1:
* Input: left = "4", right = "1000"
* Output: 4
* Explanation: 4, 9, 121, and 484 are superpalindromes.
* Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
* Example 2:
* Input: left = "1", right = "2"
* Output: 1
* Constraints:
* 1 <= left.length, right.length <= 18
* left and right consist of only digits.
* left and right cannot have leading zeros.
* left and right represent integers in the range [1, 1018].
* left is less than or equal to right.
*/

package com.leetcode.practice;

import java.math.*;

public class SuperPalindromes {
    public static void main(String[] args) {
        System.out.println(superpalindromesInRange("40000000000000000",                "50000000000000000"));
    }

    public static int superpalindromesInRange(String left, String right) {
        int count  = 0;
        boolean isCurrentPal = false;
        boolean isSqaurePal = false;
        long leftNo = Long.valueOf(left);
        long rightNo = Long.valueOf(right);
        for(long i = leftNo; i<=rightNo;i++){
            double squareRoot = Math.sqrt(i);
            if((squareRoot % 1) != 0){
                int root = (int)Math.sqrt(i);
                isCurrentPal = isPalindrome(i);
                isSqaurePal = isPalindrome(root);
                if(isCurrentPal && isSqaurePal){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(long i){
        String value = Long.toString(i);
        Long reverse = Long.parseLong(new StringBuffer(value).reverse().toString());
        return i==reverse;
    }
}
