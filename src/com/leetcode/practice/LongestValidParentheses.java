/*
* Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
* Example 1:
*
* Input: s = "(()"
*
* Output: 2
*
* Explanation: The longest valid parentheses substring is "()".
*
* Example 2:
*
* Input: s = ")()())"
*
* Output: 4
*
* Explanation: The longest valid parentheses substring is "()()".
*
* Example 3:
*
* Input: s = ""
*
* Output: 0
*
* Constraints:
*
* 0 <= s.length <= 3 * 104
*
* s[i] is '(', or ')'.
*/

package com.leetcode.practice;

import java.util.*;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        List<Character> allPairs = new ArrayList<>();
        List<Character> validPairs = new ArrayList<>();
        for(int i = 0; i < s.toCharArray().length; i++){
            if(s.charAt(i) == '('){
                allPairs.add(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                int size  = allPairs.size();
                if(size > 0){
                    char lastChar = allPairs.remove(size - 1);
                    if(lastChar == '('){
                        validPairs.add(lastChar);
                        validPairs.add(s.charAt(i));
                    }
                }
                //allPairs.add(s.charAt(i));
            }
        }
        return validPairs.size();
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses("()(()"));

    }

}
