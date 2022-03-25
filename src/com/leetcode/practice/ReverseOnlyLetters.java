/*
* Given a string s, reverse the string according to the following rules:
* All the characters that are not English letters remain in the same position.
* All the English letters (lowercase or uppercase) should be reversed.
* Return s after reversing it.
*
* Example 1:
* Input: s = "ab-cd"
* Output: "dc-ba"
*
* Example 2:
* Input: s = "a-bC-dEf-ghIj"
* Output: "j-Ih-gfE-dCba"
*
* Example 3:
* Input: s = "Test1ng-Leet=code-Q!"
* Output: "Qedo1ct-eeLg=ntse-T!"
*
* Constraints:
* 1 <= s.length <= 100
* s consists of characters with ASCII values in the range [33, 122].
* s does not contain '\"' or '\\'.
*
*/
package com.leetcode.practice;

import java.util.Stack;

public class ReverseOnlyLetters {

    //Optimized src.com.leetcode.practice1.Solution
    public String reverseOnlyLetters1(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    public static String reverseOnlyLetters(String s) {
        char[] result = new char[s.length()];
        for(int i = 0; i<s.length(); i++){
            result[i] = s.charAt(i);
        }
        int j = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                while(j<s.length() && !Character.isLetter(result[j])){
                    j++;
                }
                result[j] = ch;
                j++;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
