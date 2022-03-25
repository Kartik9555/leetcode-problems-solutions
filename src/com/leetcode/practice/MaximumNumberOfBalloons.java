/*
 *
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 * Example 1:
 * Input: text = "nlaebolko"
 * Output: 1
 *
 * Example 2:
 * Input: text = "loonbalxballpoon"
 * Output: 2
 *
 * Example 3:
 * Input: text = "leetcode"
 * Output: 0
 *
 * Constraints:
 * 1 <= text.length <= 104
 * text consists of lower case English letters only.
 *
 */
package com.leetcode.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {

    public static int maxNumberOfBalloons(String text) {
        int possibleWords = 0;
        char[] textArray = text.toCharArray();
        Map<String, Integer> charFrequencyMap = new HashMap<>();
        charFrequencyMap.put(Character.toString('b'), 0);
        charFrequencyMap.put(Character.toString('a'), 0);
        charFrequencyMap.put(Character.toString('l'), 0);
        charFrequencyMap.put(Character.toString('o'), 0);
        charFrequencyMap.put(Character.toString('n'), 0);
        for (char ch : textArray) {
            switch (ch) {
                case 'b':
                case 'a':
                case 'l':
                case 'o':
                case 'n':
                    charFrequencyMap.put(Character.toString(ch), charFrequencyMap.get(Character.toString(ch)) + 1);
                    break;
            }
        }
        int min = Collections.min(charFrequencyMap.values());
        if (charFrequencyMap.get(Character.toString('l')) <= 2 * min || charFrequencyMap.get(Character.toString('o')) <= 2 * min) {
            int lminFrequency = charFrequencyMap.get(Character.toString('l'));
            int ominFrequency = charFrequencyMap.get(Character.toString('o'));
            min = lminFrequency < ominFrequency ? lminFrequency : ominFrequency;
            possibleWords = min / 2;
        } else {
            possibleWords = min;
        }
        return possibleWords;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
        System.out.println(maxNumberOfBalloons("balllllllllllloooooooooon"));
    }
}
