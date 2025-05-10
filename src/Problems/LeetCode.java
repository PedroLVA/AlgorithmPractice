package Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
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
}
