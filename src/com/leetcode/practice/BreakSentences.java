package com.leetcode.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BreakSentences {

    public static void main(String[] args) {
        System.out.println(solution("We test coders. Give us a try?"));
        System.out.println(solution("Forget   CVs..Save time .    x x. Arggh! failes this scenaio ? This is at test case"));
    }

    public static int solution(String s){
        String[] sentences = s.split("[.!?]");
        Map<String, Integer> sentenceToWordsMap = new HashMap<>();
        for (String s1: sentences) {
            sentenceToWordsMap.put(s1, s1.trim().split("[ ]+").length);
        }
        int max = sentenceToWordsMap.size()>0 ? Collections.max(sentenceToWordsMap.values()) : 0;
        return max;
    }
}
