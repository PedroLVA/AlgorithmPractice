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
}
