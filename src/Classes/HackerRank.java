package Classes;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
        int sum = 0;
        int numPossibilities = 0;

        for(int i = 0; i < s.size() - (m - 1); i++){

            for(int j = i; j <= m - 1 + i; j++){

                sum += s.get(j);
            }

            if(sum == d){
                numPossibilities++;
                sum = 0;
            }
            else{
                sum = 0;
            }

        }
        return numPossibilities;


    }

}
