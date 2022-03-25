/*
* Count the number of prime numbers less than a non-negative number, n.
* Example 1:
* Input: n = 10
* Output: 4
* Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
* Example 2:
* Input: n = 0
* Output: 0
* Example 3:
* Input: n = 1
* Output: 0
* Constraints:
* 0 <= n <= 5 * 106
*/
package com.leetcode.practice;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(200));
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
