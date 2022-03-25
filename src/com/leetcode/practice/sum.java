package com.leetcode.practice;

public class sum {
    public static void main(String[] args) {
        mulitple(100);
    }

    public static int mulitple(int n){
        int sum = 0;
        for (int i =3; i< n; i++){
            if ((i%3 == 0)||(i%5 == 0)||(i%7==0)){
                sum += i;
            }
        }
        return sum;
    }
}
