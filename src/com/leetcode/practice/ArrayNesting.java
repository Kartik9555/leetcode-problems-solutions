/*
* You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
* You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
* The first element in s[k] starts with the selection of the element nums[k] of index = k.
* The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
* We stop adding right before a duplicate element occurs in s[k].
* Return the longest length of a set s[k].
*
* Example 1:
* Input: nums = [5,4,0,3,1,6,2]
* Output: 4
* Explanation:
* nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
* One of the longest sets s[k]:
* s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
*
* Example 2:
* Input: nums = [0,1,2]
* Output: 1
*
* Constraints:
* 1 <= nums.length <= 105
* 0 <= nums[i] < nums.length
* All the values of nums are unique.
*
*
*/
package com.leetcode.practice;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class ArrayNesting {

    public static int arrayNesting(int[] nums) {
        Map<Integer, Integer> numberSetMap = new HashMap<>();
        for(int k = 0; k<nums.length;k++){
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            set.add(nums[k]);
            list.add(nums[k]);
            boolean add = true;
            while(add){
                int num = list.get(list.size()-1);
                add = set.add(nums[num]);
                if(add){
                    list.add(nums[num]);
                }
            }
            numberSetMap.put(k, set.size());
        }
        return Collections.max(numberSetMap.values());
    }

    public static int arrayNesting1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(arrayNesting(new int[]{5,4,0,3,1,6,2}));
        System.out.println(arrayNesting(new int[]{0,1,2}));
        URL res = MaxNumberOfFruit.class.getClassLoader().getResource("input.properties");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(absolutePath);
        properties.load(inputStream);
        int[] input = Arrays.stream(properties.getProperty("array2").split(",")).mapToInt(Integer::parseInt).toArray();
        int[] input1 = Arrays.stream(properties.getProperty("array1").split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(arrayNesting(input1));
        System.out.println(arrayNesting1(input1));
    }
}
