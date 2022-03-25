package com.leetcode.practice.bowling;

public class Frame {

    private int first;
    private int second;
    private int score;
    private Frame next;

    public Frame() {
    }

    public Frame(int first, int second) {
        this.first = first;
        this.second = second;
        setScore(this.first + this.second);
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Frame getNext() {
        return next;
    }

    public void setNext(Frame next) {
        this.next = next;
    }
}
