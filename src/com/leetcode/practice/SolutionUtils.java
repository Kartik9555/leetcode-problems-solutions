package com.leetcode.practice;

import java.util.Arrays;

public class SolutionUtils {

    public static void printArray(int[] nums){
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("");
    }
}
