package Classes;

import java.util.*;

public class HackerRank {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        //There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
        //
        //The elements of the first array are all factors of the integer being considered (numeros que dividem o numero exatamente)
        //The integer being considered is a factor of all elements of the second array (Numeros que o numero divide exatamente)
        //These numbers are referred to as being between the two arrays. Determine how many such numbers exist.

        //The number we are looking for must be divisible by all numbers in the first array and divide all numbers in the second array


        int maxA = Collections.max(a);
        int minB = Collections.min(b);
        HashSet<Integer> numsA = new HashSet<Integer>();
        int count = 0;

        for (int i = maxA; i <= minB; i++) {
            int finalI = i;
            if (a.stream().allMatch(num -> finalI % num == 0)) {
                numsA.add(finalI);
            }
        }

        for(int num : numsA){
            if(b.stream().allMatch(bNum -> bNum % num == 0)){ // Must divide all b[]
                count++;
            }
        }
        System.out.println(numsA);

        System.out.println();
        return count;


        //dentre 100, os numeros que são divididos sem resto pelo primeiro array e colocar eles no hashset

        //


    }
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int highestScore = scores.get(0);
        int lowestScore = scores.get(0);
        int countMost = 0;
        int countLeast = 0;

        for(int i = 1; i < scores.size(); i++){
            if(scores.get(i) > highestScore){
                highestScore = scores.get(i);
                countMost++;
            }
            if(scores.get(i) < lowestScore){
                lowestScore = scores.get(i);
                countLeast++;
            }
        }
        return List.of(countMost, countLeast);

    }
    public static int birthday(List<Integer> s, int d, int m) {
        // Edge case: if the chocolate bar is smaller than the birth month
        if (s.size() < m) {
            return 0;
        }

        int numPossibilities = 0;
        int currentSum = 0;

        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }

        if (currentSum == d) {
            numPossibilities++;
        }

        for (int i = m; i < s.size(); i++) {
            currentSum = currentSum + s.get(i) - s.get(i - m);

            if (currentSum == d) {
                numPossibilities++;
            }
        }

        return numPossibilities;
    }
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int numOfPairs = 0;
        for(int i = 0; i < ar.size(); i++){
            for(int j = i + 1; j < ar.size(); j++){
                if((ar.get(i) + ar.get(j)) % k == 0){
                    numOfPairs++;
                }
            }
        }
        return numOfPairs;

    }
    public static int migratoryBirds(List<Integer> arr) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int id : arr){
            if(hashmap.containsKey(id)){
                hashmap.put(id, hashmap.get(id) + 1);
            }
            else {
                hashmap.put(id, 1);
            }
        }
        int maxValue = Integer.MIN_VALUE;
        int lowestKey = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                lowestKey = entry.getKey();
            }
            if (entry.getValue() == maxValue && entry.getKey() < lowestKey) {
                lowestKey = entry.getKey();
            }
        }
        return lowestKey;

    }
    public static String dayOfProgrammer(int year) {
        int day;

        if (year == 1918) {

            day = 26;
        } else if (year < 1918) {

            day = (year % 4 == 0) ? 12 : 13;
        } else {

            day = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 12 : 13;
        }

        return day + ".09." + year;

    }
    public static void bonAppetit(List<Integer> bill, int k, int b) {

        int sumOfAllItemsInBill = 0;
        for(int num : bill){
            sumOfAllItemsInBill += num;
        }

        int annaShouldPay = (sumOfAllItemsInBill - bill.get(k))/2;

        System.out.println(annaShouldPay == b ? "Bon Appetit" : (b - annaShouldPay));


    }
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer, Integer> pairs = new HashMap<>();
        int countPairs = 0;
        for (int i : ar) {
            if (pairs.containsKey(i)) {
                pairs.put(i, pairs.get(i) + 1);
                if (pairs.get(i) % 2 == 0) {
                    countPairs++;
                }
            } else {
                pairs.put(i, 1);
            }
        }
        return countPairs;
    }


}


