/*
* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
* You must implement a solution with a linear runtime complexity and use only constant extra space.
*
* Example 1:
* Input: nums = [2,2,1]
* Output: 1
*
* Example 2:
* Input: nums = [4,1,2,1,2]
* Output: 4
*
* Example 3:
* Input: nums = [1]
* Output: 1
*
* Constraints:
* 1 <= nums.length <= 3 * 104
* -3 * 104 <= nums[i] <= 3 * 104
* Each element in the array appears twice except for one element which appears only once.
*
*/
package com.leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;
        Map<Integer, Long> numMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(Integer i : numMap.keySet()){
            if(numMap.get(i) == 1){
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1}));
    }
}
