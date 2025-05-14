package Problems;

import java.util.*;

class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class LeetCode {

    public static int longestConsecutive(int[] nums) {
        //this way it wont work because we have duplicates
        int count = 1;
        int maxCount = 0;
        Arrays.sort(nums);
        //sorted array

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);

        return maxCount;

    }

    public static int longestConsecutiveHashSet(int[] nums) {
        //this solution works but further optimizations needed for log(n)
        HashSet<Integer> hashSet = new HashSet<>();
        int maxCount = 0;

        for (int num : nums) {
            hashSet.add(num);
        }

        for (int num : hashSet) {

            if(!hashSet.contains(num-1)){

                int currentNum = num;
                int count = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxCount = Math.max(count, maxCount);
            }

        }
        return maxCount;

    }
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();

        ListNode current = head;

        while (current != null) {

            if (visited.contains(current)) {
                return true;
            }

            visited.add(current);

            current = current.next;

        }

        return false;

    }
    public boolean hasCycleFloyd(ListNode head) {
        // Edge case: empty list or list with only one node
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Move slow one step and fast two steps at a time
        // If there's a cycle, they will eventually meet
        while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;

           if(fast == slow){
               return true;
           }
        }

        // If fast reaches the end (null), there's no cycle
        return false;
    }
    public int missingNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }


        for (int i = 0; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }

        return -1;
    }
    public int missingNumberMath(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int actualSum = 0;

        for(int i = 0; i < length; i++){
            sum += i;
        }

        for(int num : nums){
            actualSum += num;
        }

        return sum - actualSum;

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        List<ListNode> nodes = new ArrayList<>();

        ListNode pointer = list1;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }

        pointer = list2;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }

        if (nodes.isEmpty()) {
            return null;
        }

        Collections.sort(nodes, (a, b) -> a.val - b.val);

        ListNode head = nodes.get(0);
        ListNode current = head;
        for (int i = 1; i < nodes.size(); i++) {
            current.next = nodes.get(i);
            current = current.next;
        }
        current.next = null; // Important: Terminate the list

        return head;
    }
    public ListNode mergeTwoListsGoodApproach(ListNode list1, ListNode list2) {

        //dummy age como um ponto de partida, como ele e tail são a mesma referencia, dummy.next é o primeiro tail.next
        //o que significa que conseguimos acessar o head mesmo depois de percorrer a lista toda
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        //aqui uma das listas vai estar vazia, talvez, ai e so colocar no final pois ja esta sorted
        if(list1 != null){
            tail.next = list1;
        }
        else{
            tail.next = list2;
        }

        //retorna a head
        return dummy.next;

    }
    public static boolean isValid(String s) {
        //if its not even, its false
        Stack<Character> stack = new Stack<>();

        HashSet<Character> openingCharacters = new HashSet<>();
        openingCharacters.add('{');
        openingCharacters.add('(');
        openingCharacters.add('[');

        HashMap<Character, Character> pairHashmap = new HashMap<>();
        pairHashmap.put(']', '[');
        pairHashmap.put(')', '(');
        pairHashmap.put('}', '{');

        if(s.length() % 2 !=0){
            return false;
        }

        for(Character bracket : s.toCharArray()){

        if(openingCharacters.contains(bracket)){
            stack.add(bracket);
        }
        else{
            if(stack.isEmpty()){
                return false;
            }

            if(stack.peek() == pairHashmap.get(bracket)){
                stack.pop();
            }else{
                return false;
            }
        }

        }
        return stack.isEmpty();
    }
    public static int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }


        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;


        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
