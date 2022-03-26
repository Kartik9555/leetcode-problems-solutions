/* Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every letter in a string by a fixed number,K , making it unreadable by his enemies. Given a string, S, and a number, N, encrypt  and print the resulting string.
Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
Input Format
The first line contains an integer,N , which is the length of the unencrypted string. 
The second line contains the unencrypted string, S. 
The third line contains the integer encryption key, K, which is the number of letters to rotate.
Constraints 
1<=N<=100;
0<=K<=100 
S is a valid ASCII string and doesn't contain any spaces.

Output Format

For each test case, print the encoded string.

Sample Input

11
middle-Outz
2
Sample Output

okffng-Qwvb
Explanation

Each unencrypted letter is replaced with the letter occurring K spaces after it when listed alphabetically. Think of the alphabet as being both case-sensitive and circular; if K rotates past the end of the alphabet, it loops back to the beginning (i.e.: the letter after z is a, and the letter after Z is A).

Selected Examples: 
m (ASCII 109) becomes  o (ASCII 111). 
i (ASCII 105) becomes  k (ASCII 107). 
- remains the same, as symbols are not encoded. 
O (ASCII 79) becomes  Q(ASCII 81). 
z (ASCII 122) becomes  b(ASCII 98); because  is the last letter of the alphabet,  a(ASCII 97) is the next letter after it in lower-case rotation. 
*/
package src.com.leetcode.practice1;

import java.io.*;
import java.util.*;

public class CaesarCipher {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named src.com.leetcode.practice1.Solution. */
            int num=0;
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			String str = sc.next();
			int k = sc.nextInt()%26;
			StringBuffer sb = new StringBuffer(str);
			for(int i=0;i<n;i++){
				num=0;
				char ch;
				ch = str.charAt(i);
				if((int)ch >= 65 && (int)ch <= 90)
				{
					num = (int)ch + k;
					if(num>90){
						num=64+num-90;
					}
					sb.setCharAt(i, (char)num);

				}
				if((int)ch >= 97 && (int)ch <= 122)
				{
					num = (int)ch + k;
					if(num>122){
						num=96+num-122;
						}
					sb.setCharAt(i, (char)num);

				}


			}
			System.out.println(sb);
			sc.close();
			}
}
