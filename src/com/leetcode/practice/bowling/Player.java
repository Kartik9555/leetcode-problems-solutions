package com.leetcode.practice.bowling;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {

    private Frame start;
    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public void play(int currentFrameNo){
        Scanner in = new Scanner(System.in);
        int first = 0;
        int second = 0;
        boolean bonusAttempt = false;
        System.out.println("Enter first attempt score for Frame "+(currentFrameNo+1)+": ");
        first = in.nextInt();
        if(first == 10){
            System.out.println("Strike !!!!");
        } else{
            System.out.println("Enter second attempt score for Frame "+(currentFrameNo+1)+": ");
            second = in.nextInt();
        }
        Frame next = new Frame(first, second);
        Frame previous = null;
        Frame current = null;
        if(start == null){
            start = next;
        }else{
            current = start;
            previous = start;
            while(current.getNext() != null){
                previous = current;
                current  = current.getNext();
            }
            current.setNext(next);
        }
        if(previous != current){
            updateFrameScore(current);
            updateFrameScore(previous);
        }
        if(currentFrameNo == 9){
            previous = current;
            current = next;
            if(first == 10){
                System.out.println("You get 2 more attempts");
                System.out.println("Enter first attempt score:");
                first = in.nextInt();
                System.out.println("Enter second attempt score:");
                second = in.nextInt();
                next = new Frame(first, second);
                bonusAttempt = true;
            } else if(first + second == 10){
                System.out.println("You get 1 more attempts");
                System.out.println("Enter attempt score:");
                first = in.nextInt();
                next = new Frame(first, 0);
                bonusAttempt = true;
            }
        }
        if(bonusAttempt){
            // Add bonus frame
            current.setNext(next);
            updateFrameScore(current);
            updateFrameScore(previous);
            // remove bonus frame
            current.setNext(null);
        }
        updateTotalScore();
    }

    public void updateFrameScore(Frame frame){
        if(isStrike(frame) && isStrike(frame.getNext()) && frame.getNext().getNext()!=null){
            frame.setScore(20 + frame.getNext().getNext().getFirst());
        } else if(isStrike(frame)){
            frame.setScore(10 + frame.getNext().getFirst() + frame.getNext().getSecond());
        } else if (isSpare(frame)){
            frame.setScore(frame.getFirst() + frame.getSecond() + frame.getNext().getFirst());
        } else {
            frame.setScore(frame.getFirst() + frame.getSecond());
        }
    }

    public boolean isStrike(Frame frame){
        return frame.getFirst() == 10;
    }

    public boolean isSpare(Frame frame){
        return (frame.getFirst()+frame.getSecond()) == 10;
    }

    public void updateTotalScore(){
        Frame head = start;
        int finalScore = 0;
        while(head != null){
            finalScore += head.getScore();
            head = head.getNext();
        }
        totalScore = finalScore;
    }

    public void printFrames(){
        int count = 0;
        Frame head = start;
        while(head != null){
            count++;
            System.out.println("Frame"+count+": ");
            System.out.println("Frame"+count+" score: "+head.getScore());
            head = head.getNext();
        }
    }
}
