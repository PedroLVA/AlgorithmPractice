package Problems;

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
    public static int pageCount(int n, int p) {
        // Calculate page turns from front
        int fromFront = p / 2;


        int fromBack = n / 2 - p / 2;

      
        return Math.min(fromFront, fromBack);
    }
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int numberOfValleys = 0;
        int beforeAltitude = 0;
        int altitude = 0;

        for(int i = 0; i < path.length(); i++){

            altitude += (path.charAt(i) == 'D') ? -1 : +1;
            if(beforeAltitude == 0 && altitude < 0){
                numberOfValleys++;
            }
            beforeAltitude = altitude;
        }
        return numberOfValleys;



    }
    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int highestValue = -1;

        for(int i = 0; i < keyboards.length; i++){
            for(int j = 0; j < drives.length; j++){
                int sum = keyboards[i] + drives[j];

                if(sum == b) {
                    return b;
                }

                if(sum > highestValue && sum <= b){
                    highestValue = sum;
                }
            }
        }

        return highestValue;
    }
    public static String catAndMouse(int x, int y, int z) {
        int catADistance = Math.abs(z - x);
        int catBDistance = Math.abs(z - y);

        if (catADistance < catBDistance) {
            return "Cat A";
        } else if (catADistance > catBDistance) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }
    public static int pickingNumbers(List<Integer> a) {
        int biggestArray = Integer.MIN_VALUE;

        //Hashmao that has id and size of array
        HashMap<Integer,Integer> hm = new HashMap<>();
        int biggestSetSize = Integer.MIN_VALUE;

        for(int i = 0; i < a.size(); i++ ){
            if(hm.containsKey(a.get(i))){
                hm.put(a.get(i), hm.get(i) + 1);
            }
            else{
                hm.put(a.get(i), 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {

            Integer currentKey = entry.getKey();
            Integer currentValue = entry.getValue();

            for (Map.Entry<Integer, Integer> otherEntry : hm.entrySet()) {

                if (currentKey.equals(otherEntry.getKey())) continue;


                if (Math.abs(currentKey - otherEntry.getKey()) == 1) {

                    int combined = currentValue + otherEntry.getValue();
                    if(combined > biggestSetSize){
                        biggestSetSize = combined;
                    }
                    // ...
                }
            }
        }
        return biggestSetSize;
    }
    public static int hurdleRace(int k, List<Integer> height) {

        int maxHeight = 0;
        int result = 0;
        for(int h : height){
            maxHeight = Math.max(h, maxHeight);
        }

        result = (maxHeight <= k) ?  0 : maxHeight-k;
        return result;


    }
    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        //get the highest letter of the word
        //How to get the correct letter value inteligently? Dunno so I'll use a hashmap

        int wordLength = word.length();
        int heighestLetter = 1;

        for(int i = 0; i < wordLength; i++){
            int letterHeight = h.get(word.charAt(i) - 'a');

            heighestLetter = Math.max(letterHeight, heighestLetter);

        }
        return heighestLetter * wordLength;




    }
    public static int utopianTree(int n) {
        // Write your code here
        //spring (double) - summer (adds 1)
        int treeHeight = 1;

        if(n == 0){
            return 1;
        }

        for(int i = 0; i < n; i++){
            if( i % 2 == 0){
                treeHeight *= 2 ;
            }
            else{
                treeHeight++;
            }
        }
        return treeHeight;

    }
    public static String angryProfessor(int k, List<Integer> a) {
        int count = 0;

        for (Integer integer : a) {
            if (integer > 0) {
                count++;
            }
        }
        if(a.size() - count >= k){
            return "NO";
        }
        else{
            return "YES";
        }

    }
    public static int beautifulDays(int i, int j, int k) {
        int beautifulDaysCounter = 0;


        int reversedNumber = 0;

        for(int index = i; index <= j; index++){
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(index));
            sb.reverse();
            reversedNumber = Integer.parseInt(sb.toString());

            System.out.println(reversedNumber);

            if((index - reversedNumber) % k == 0){
                beautifulDaysCounter++;
            }
        }
        System.out.println(beautifulDaysCounter);
        return beautifulDaysCounter;


    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> listOfRanks = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int presentRank = 1;

        //getting the ranks
        for(int i = 0; i < ranked.size(); i++){
            if( i == 0){
                listOfRanks.add(presentRank);
                continue;
            }
            //if it's equal
            if(ranked.get(i) == ranked.get(i - 1)){
                listOfRanks.add(presentRank);
            }
            //if it's smaller

            else if(ranked.get(i) < ranked.get(i - 1)){
                presentRank++;
                listOfRanks.add(presentRank);
            }
        }

        //another for loop comparing each element, since both arrays have the matching index,
        //we can use that

        for(int i = 0; i < player.size(); i++){
            int playerScore = player.get(i);

            //inside the ranks comparing
            for(int j = 0; j < ranked.size(); j++){

                if(j == 0){
                    if(playerScore >= ranked.get(j)){
                        result.add(listOfRanks.get(j));
                    }
                }
                else if(j == ranked.size() - 1){
                    if (playerScore < ranked.get(j)){
                        result.add(listOfRanks.get(j) + 1);
                        break;
                    }
                }

                if(playerScore == ranked.get(j)){
                    result.add(listOfRanks.get(j));
                }
                else if(playerScore > ranked.get(j) && playerScore < ranked.get(j - 1)){
                    result.add(listOfRanks.get(j));
                }
            }




        }

        return result;


    }

    public static int saveThePrisoner(int n, int m, int s) {
        int position = ((s - 1) + (m - 1)) % n + 1;
        return position;
    }
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here
        //moves the last to the first and shifts everything to the right
        //first we need to rotate it
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < k; i++){
            //get the last element
            int lastElement = a.get(a.size() -1 );
            //remove the last element
            a.remove(a.size() -1);
            //add the last element to the start
            a.add(0, lastElement);

            //this works
        }
        for(int i = 0; i < queries.size(); i++){
            answer.add(a.get(queries.get(i)));
        }


        return answer;

    }
    static int jumpingOnClouds(int[] c, int k) {
        //thunderhead of cumulus
        //should reach the start again
        //c clouds = array,
        //e energy = 100
        //thundercloud is c[i] = 1
        //jump of size k to cloud c[(i+k) % n ]
        int n = c.length;
        int energy = 100;
        int currentCloud = 0;


        do{
            currentCloud = (currentCloud + k) % n;
            energy--;

            if(c[currentCloud] == 1){
                energy -= 2;
            }

        }while(currentCloud != 0);
        return energy;

    }
    public static List<Integer> permutationEquation(List<Integer> p) {
        int length = p.size();
        List<Integer> result = new ArrayList<>();

        for(int x = 1; x <= length; x++){
            int currentIndex = p.indexOf(x) + 1;
            int answer = p.indexOf(currentIndex) + 1;
            result.add(answer);
        }
        return result;
    }
    public static int findDigits(int n) {
        // Write your code here
        // it's a divisor if it can be perfectly divised
        //check if the integer composing numbers can divide the integer evenly
        //so I need to get all the individual numbers to make it work
        String stringNumber = Integer.toString(n);
        ArrayList<Character> arrayOfNumbers = new ArrayList<>();
        int countDivisible = 0;
        for(int i = 0; i < stringNumber.length(); i++){
            arrayOfNumbers.add(stringNumber.charAt(i));
        }
        for(char num : arrayOfNumbers){
            int singularNumber = Character.getNumericValue(num);
            if(singularNumber == 0){
                continue;
            }
            if(n % singularNumber == 0 ){
                countDivisible++;
            }
        }
        return countDivisible;
    }

}



