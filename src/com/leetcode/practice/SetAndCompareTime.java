package com.leetcode.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SetAndCompareTime {

    public static void main(String[] args) {
        String practiceExpirationDate = LocalDateTime.now().withHour(20).withMinute(0).withSecond(0).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println(practiceExpirationDate);
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime practiceExpiration = LocalDateTime.parse(practiceExpirationDate,
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime defaultPracticeExpirationTime = LocalDateTime.now().withHour(18).withMinute(0).withSecond(0);
        LocalDateTime currentTime = LocalDateTime.now();
        if(currentTime.isAfter(defaultPracticeExpirationTime)){
            System.out.println("Practice can not be activated");
        }
    }
}
