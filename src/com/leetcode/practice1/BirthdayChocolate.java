/* Lily has a chocolate bar consisting of a row of n squares where each square has an integer written on it. She wants to share it with Ron for his birthday, which falls on month m and day d. Lily wants to give Ron a piece of chocolate only if it contains m consecutive squares whose integers sum to d.

Given m, d, and the sequence of integers written on each square of Lily's chocolate bar, how many different ways can Lily break off a piece of chocolate to give to Ron?

For example, if m=2, d=3 and the chocolate bar contains n rows of squares with the integers [1,2,1,3,2] written on them from left to right, the following diagram shows two ways to break off a piece:

Input Format

The first line contains an integer denoting n (the number of squares in the chocolate bar). 
The second line contains n space-separated integers describing the respective values of s0, s1, s2....sn-1 (the numbers written on each consecutive square of chocolate). 
The third line contains two space-separated integers describing the respective values of  d(Ron's birth day) and m(Ron's birth month).

Output Format

Print an integer denoting the total number of ways that Lily can give a piece of chocolate to Ron.

Sample Input 0

5
1 2 1 3 2 
3 2
Sample Output 0

2
Explanation 0

This sample is already explained in the problem statement.

Sample Input 1

6
1 1 1 1 1 1
3 2
Sample Output 1

0

 */
package src.com.leetcode.practice1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayChocolate {

    static int solve(int n, int[] s, int d, int m){
        // Complete this function
        int noOfChocolates=0;
        for(int i=0;i<=(n-m);i++){
            int count=0;
            int sum=0;
            while(count<m){
                sum+=s[count+i];
                count++;
            }
            if(sum==d)
                noOfChocolates++;
                
        }
        return noOfChocolates;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
