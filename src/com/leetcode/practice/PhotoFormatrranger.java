package com.leetcode.practice;

import java.util.*;

public class PhotoFormatrranger {

    public static void main(String[] args) {
        System.out.print(solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11"));
    }

    public static String solution(String s){
        String[] oldPhotNames = s.split("\n");
        Map<String, String> namesMap = new LinkedHashMap<>();
        Map<String, List<String>> cityToPhotoTime = new HashMap<>();
        for (String photoName: oldPhotNames){
            String[] split = photoName.split(",");
            namesMap.put(split[0].trim(), split[0].trim());
            if(cityToPhotoTime.containsKey(split[1].trim())){
                cityToPhotoTime.get(split[1].trim()).add(split[2].trim()+"_"+split[0].trim());
            }else {
                List<String> a = new ArrayList<>();
                a.add(split[2].trim()+"_"+split[0]);
                cityToPhotoTime.put(split[1].trim(),a);
            }
        }
        for (String key: cityToPhotoTime.keySet()) {
            List<String> photos = cityToPhotoTime.get(key);
            Collections.sort(photos);
            int padding = String.valueOf(photos.size()).length();
            int count = 1;
            for(String name : photos){
                String newName = key + String.format("%1$"+padding+ "s", count).replace(' ', '0') + "." + name.substring(name.lastIndexOf(".")+1);
                count++;
                namesMap.put(name.substring(name.lastIndexOf("_")+1),newName);
            }

        }

        String[] arr = new String[namesMap.values().size()];
        namesMap.values().toArray(arr);

        return String.join("\n", arr);
    }
}
