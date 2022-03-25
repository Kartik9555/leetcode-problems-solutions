package com.leetcode.practice;

import java.util.*;

public class CalculateTransfer {
    public static void main(String[] args) {
        System.out.println(soltion(new int[]{100,100,100}, new String[]{"2020-12-31","2020-12-22","2020-12-03"}));
        System.out.println(soltion(new int[]{180,-50,-25,-25}, new String[]{"2020-01-01","2020-01-01","2020-01-01","2020-01-31"}));
        System.out.println(soltion(new int[]{1,-1,0,-105,1}, new String[]{"2020-12-31","2020-04-04","2020-04-04","2020-04-14","2020-07-12"}));
        System.out.println(soltion(new int[]{100,100,-10,-20,-30}, new String[]{"2020-01-01","2020-02-01","2020-02-11","2020-02-05","2020-02-08"}));
    }

    public static int soltion(int[] A, String[] D){
        Map<String, List<Integer>> monthToTransactionMap = new HashMap<>();
        for (int i = 1; i<=12; i++) {

            monthToTransactionMap.put( i<10 ? "0" + i : i +"" ,new ArrayList<>());
        }
        for (int i = 0; i<D.length; i++) {
            String month = D[i].substring(5,7);
            monthToTransactionMap.get(month).add(A[i]);
        }

        int totalAmount = 0;
        for (List<Integer> value : monthToTransactionMap.values()) {
            totalAmount+= getChargesbyMonth(value);
        }
        return totalAmount;
    }

    public static int getChargesbyMonth(List<Integer> moneyTransactions){
        int noOfCardPayments = 0;
        int totalCost = 0;
        int totalCardPayments = 0;
        int transactionsCost = 0;
        for (Integer t: moneyTransactions){
            if(t<0){
                noOfCardPayments++;
                totalCardPayments+= t;
            }
            transactionsCost+= t;
        }
        if(noOfCardPayments < 3 || totalCardPayments > -100){
            totalCost = transactionsCost - 5;
        } else{
            totalCost = transactionsCost ;
        }
        return totalCost;
    }
}
