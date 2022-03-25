/*
*
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* Note that you must do this in-place without making a copy of the array.
*
* Example 1:
* Input: nums = [0,1,0,3,12]
* Output: [1,3,12,0,0]
*
* Example 2:
* Input: nums = [0]
* Output: [0]
*
* Constraints:
* 1 <= nums.length <= 104
* -231 <= nums[i] <= 231 - 1
*
*/
package com.leetcode.practice;

import java.util.Arrays;

public class MoveZeroes {

    public static int[] moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] != 0){
                result[index++] = nums[i];
            }
        }
        return result;
    }

    public static int[] moveZeroes1(int[] nums) {
        int n = nums.length;
        int j = -1;
        int i = 0;

        while(i < n ){

            //first occurence of 0
            if(nums[i] == 0 && j == -1) j = i;
                //has zero in the array before a valid digit, hence swap
            else if(nums[i] != 0 && j != -1 ){
                nums[j] = nums[i];
                nums[i] = 0;
                j++ ;
            }
            i++;
        }
        return nums;
    }

    public static int[] moveZeroes2(int[] nums){
        int a;
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                a = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = a;
                lastNonZeroFoundAt++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SolutionUtils.printArray(moveZeroes(new int[]{0,1,0,3,12}));
        SolutionUtils.printArray(moveZeroes1(new int[]{0,1,0,3,12}));
        SolutionUtils.printArray(moveZeroes2(new int[]{0,1,0,3,12}));
        SolutionUtils.printArray(moveZeroes(new int[]{0}));
    }
}
