/*
* Given a signed 32-bit integer x, return x with its digits reversed.
* If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
* Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
*
* Example 1:
* Input: x = 123
* Output: 321
*
* Example 2:
* Input: x = -123
* Output: -321
*
* Example 3:
* Input: x = 120
* Output: 21
*
* Constraints:
* -231 <= x <= 231 - 1
*/
package com.leetcode.practice;

public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;
        boolean isNegative = x<0;
        StringBuffer num = new StringBuffer().append(x);
        num = isNegative ? new StringBuffer(num.substring(1)) : num;
        num = num.reverse();
        String n = isNegative ? new StringBuffer("-").append(num).toString() : num.toString();
        try{
            result = Integer.parseInt(n);
        }catch(Exception e){
            result = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}
