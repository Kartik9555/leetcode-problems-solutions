/*
* Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.
*
* Example 1:
* Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
* Output: 16
* Explanation: The two words can be "abcw", "xtfn".
*
* Example 2:
* Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
* Output: 4
* Explanation: The two words can be "ab", "cd".
*
* Example 3:
* Input: words = ["a","aa","aaa","aaaa"]
* Output: 0
* Explanation: No such pair of words.
*
* Constraints:
* 2 <= words.length <= 1000
* 1 <= words[i].length <= 1000
* words[i] consists only of lowercase English letters.
*
*/
package com.leetcode.practice;

public class MaximumProductOfWordLengths {

    public static int maxProduct(String[] words) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }
}
