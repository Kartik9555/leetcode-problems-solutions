package com.leetcode.practice;

import sun.security.util.*;

import java.util.*;

public class Sol {

    public static void main(String[] args) {
        String[] parts=new String[]{"*====#","X-+-+-+-+-+-Z","#____X","A....*"};

        StringBuffer result=new StringBuffer();
        int count = 0;
        int[] considered = new int[parts.length];
        int charAWordIndex = 0;
        for(int i = 0;i<parts.length;i++){
            if(parts[i].toUpperCase().toCharArray()[0]=='A'){
                charAWordIndex = i;
                considered[i] = 1;
                count++;
                result.append(parts[i]);
                break;
            }
        }
        while(count<parts.length) {
            for (int i = 0; i < parts.length; i++) {
                if (considered[i] == 0 && parts[i].toUpperCase().toCharArray()[0] == result.toString().toUpperCase().toCharArray()[result.length() - 1]) {
                    considered[i] = 1;
                    result.append(parts[i].substring(1));
                    count++;
                }
            }
        }
        System.out.println(result);
    }
}
