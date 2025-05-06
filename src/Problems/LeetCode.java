package Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LeetCode {

    public static int longestConsecutive(int[] nums) {
        //this way it wont work because we have duplicates
        int count = 1;
        int maxCount = 0;
        Arrays.sort(nums);
        //sorted array

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] == nums[i] + 1 ){
                count++;
            }
            else{
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);

        return maxCount;

    }
}
