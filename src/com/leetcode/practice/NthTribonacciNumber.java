/*
*
* The Tribonacci sequence Tn is defined as follows:
* T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
* Given n, return the value of Tn.
*
* Example 1:
* Input: n = 4
* Output: 4
* Explanation:
* T_3 = 0 + 1 + 1 = 2
* T_4 = 1 + 1 + 2 = 4
*
* Example 2:
* Input: n = 25
* Output: 1389537
*
* Constraints:
* 0 <= n <= 37
* The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
*
*/
package com.leetcode.practice;

public class NthTribonacciNumber {

    public static int tribonacci(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i< arr.length; i++){
            if(i == 0){
                arr[i] = 0;
            } else if (i == 1 || i == 2){
                arr[i] = 1;
            }else {
                arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(0));
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
        System.out.println(tribonacci(37));
    }
}
