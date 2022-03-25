package com.leetcode.practice;

import java.util.Arrays;
import java.util.List;

public class StringWord {

    public static void main(String... args) {
        System.out.println(wordSplit(new String[]{"baseball", "a,all,ball,bas,base,cat,code,d,e,quit,z"}));
        System.out.println(wordSplit(new String[]{"hellocat", "apple,bat,cat,goodbye,hello,yellow,why"}));
        //hello,cat
    }

    static String  wordSplit(String[] arg) {
        String wordToSplit = arg[0];
        List<String> dictionary = Arrays.asList(arg[1].split(","));
        for(int i = 1; i<wordToSplit.length(); i++){
            String firstWord = wordToSplit.substring(0, i);
            String secondWord = wordToSplit.substring(i);
            if(dictionary.contains(firstWord) && dictionary.contains(secondWord)){
                wordToSplit = firstWord + ","+secondWord;
                break;
            }
        }
        return wordToSplit;
    }
}
