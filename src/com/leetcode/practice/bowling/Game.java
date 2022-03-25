package com.leetcode.practice.bowling;

public class Game {
    public static void main(String[] args) {
        Player player = new Player();
        for(int i = 0; i<10; i++){
            player.play(i);
            System.out.println("Score after Frame is "+player.getTotalScore());
        }
        System.out.println("Score is: "+player.getTotalScore());
        //player.printFrames();
    }
}
