/*
* You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
* The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
* Increment the large integer by one and return the resulting array of digits.
*
* Example 1:
* Input: digits = [1,2,3]
* Output: [1,2,4]
* Explanation: The array represents the integer 123.
* Incrementing by one gives 123 + 1 = 124.
* Thus, the result should be [1,2,4].
*
* Example 2:
* Input: digits = [4,3,2,1]
* Output: [4,3,2,2]
* Explanation: The array represents the integer 4321.
* Incrementing by one gives 4321 + 1 = 4322.
* Thus, the result should be [4,3,2,2].
*
* Example 3:
* Input: digits = [0]
* Output: [1]
* Explanation: The array represents the integer 0.
* Incrementing by one gives 0 + 1 = 1.
* Thus, the result should be [1].
*
* Example 4:
* Input: digits = [9]
* Output: [1,0]
* Explanation: The array represents the integer 9.
* Incrementing by one gives 9 + 1 = 10.
* Thus, the result should be [1,0].
*
* Constraints:
* 1 <= digits.length <= 100
* 0 <= digits[i] <= 9
* digits does not contain any leading 0's.
*
*/
package com.leetcode.practice;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        boolean isCarryOverNeeded = true;
        int n = digits.length - 1;
        while(isCarryOverNeeded && n >= 0){
            int sum = digits[n] + 1;
            if(sum>9){
                isCarryOverNeeded = true;
                String value = String.valueOf(sum);
                digits[n] = Integer.parseInt(Character.toString(value.charAt(value.length()-1)));
            } else {
                isCarryOverNeeded = false;
                digits[n] = sum;
            }
            n--;
        }
        if(isCarryOverNeeded){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 1; i < result.length; i++){
                result[i] = digits[i-1];
            }
            digits = result;
        }
        return digits;
    }

    public static void main(String[] args) {
        SolutionUtils.printArray(plusOne(new int[]{1,2,3}));
        SolutionUtils.printArray(plusOne(new int[]{4,3,2,1}));
        SolutionUtils.printArray(plusOne(new int[]{0}));
        SolutionUtils.printArray(plusOne(new int[]{9}));
        SolutionUtils.printArray(plusOne(new int[]{4,9,9,9}));
        SolutionUtils.printArray(plusOne(new int[]{9,9,9,9}));
    }

}
