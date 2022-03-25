/*
* You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits
* where fruits[i] is the type of fruit the ith tree produces. You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
* You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
* Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
* Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
* Given the integer array fruits, return the maximum number of fruits you can pick.
*
* Example 1:
* Input: fruits = [1,2,1]
* Output: 3
* Explanation: We can pick from all 3 trees.
*
* Example 2:
* Input: fruits = [0,1,2,2]
* Output: 3
* Explanation: We can pick from trees [1,2,2].
* If we had started at the first tree, we would only pick from trees [0,1].
*
* Example 3:
* Input: fruits = [1,2,3,2,2]
* Output: 4
* Explanation: We can pick from trees [2,3,2,2].
* If we had started at the first tree, we would only pick from trees [1,2].
*
* Example 4:
* Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
* Output: 5
* Explanation: We can pick from trees [1,2,1,1,2].
*
* Constraints:
* 1 <= fruits.length <= 105
* 0 <= fruits[i] < fruits.length
*
*/

package com.leetcode.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class MaxNumberOfFruit {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Map<Integer, Integer>> fruitCount = new TreeMap<>();
        for(int i = 0; i<fruits.length-1; i++){
            Map<Integer, Integer> count = new HashMap<>();
            int loopTraversed = 0;
            for(int j = i; j< fruits.length; j++){
                if(count.containsKey(fruits[j])){
                    count.put(fruits[j], count.get(fruits[j])+fruits[j]);
                }else{
                    count.put(fruits[j], fruits[j]);
                }
                loopTraversed++;
                if(count.size() ==2 && (j+1) != fruits.length && !count.containsKey(fruits[j+1])){
                    break;
                }
            }
            fruitCount.put(loopTraversed, count);
        }
        return fruits.length == 1 ? 1 : (fruitCount.isEmpty() ? 0 : Collections.max(fruitCount.keySet()));
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL res = MaxNumberOfFruit.class.getClassLoader().getResource("input.properties");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(absolutePath);
        properties.load(inputStream);
        int[] input = Arrays.stream(properties.getProperty("fruits").split(",")).mapToInt(Integer::parseInt).toArray();
        long startTime = System.currentTimeMillis();
        System.out.println(totalFruit(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Method execution completed in: " +(endTime - startTime));
        //System.out.println(totalFruit(new int[]{0}));
        //System.out.println(totalFruit(new int[]{1,2,1}));
        //System.out.println(totalFruit(new int[]{0,1,2,2}));
        //System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        //System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
