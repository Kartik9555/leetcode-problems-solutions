/*
* Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
* An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
* s = s1 + s2 + ... + sn
* t = t1 + t2 + ... + tm
* |n - m| <= 1
* The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
* Note: a + b is the concatenation of strings a and b.
* Example 1:
* Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
* Output: true
*
* Example 2:
* Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
* Output: false
*
* Example 3:
* Input: s1 = "", s2 = "", s3 = ""
* Output: true
*
* Constraints:
* 0 <= s1.length, s2.length <= 100
* 0 <= s3.length <= 200
* s1, s2, and s3 consist of lowercase English letters.
*/
package com.leetcode.practice;

import java.util.Map;
import java.util.TreeMap;

public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean result = false;
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()){
            result = true;
        } else {
            Map<String, Integer> mainString = new TreeMap<>();
            Map<String, Integer> interleavedString = new TreeMap<>();
            for (Character c : s1.toCharArray()){
                String key = Character.toString(c);
                if(mainString.containsKey(key)){
                    mainString.put(key, mainString.get(key) + 1);
                }else{
                    mainString.put(key, 1);
                }
            }

            for (Character c : s2.toCharArray()){
                String key = Character.toString(c);
                if(mainString.containsKey(key)){
                    mainString.put(key, mainString.get(key) + 1);
                }else{
                    mainString.put(key, 1);
                }
            }

            for (Character c : s3.toCharArray()){
                String key = Character.toString(c);
                if(interleavedString.containsKey(key)){
                    interleavedString.put(key, interleavedString.get(key) + 1);
                }else{
                    interleavedString.put(key, 1);
                }
            }
            result = interleavedString.equals(mainString);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("", "", ""));
    }
}
