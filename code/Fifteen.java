/**
 * Question 3sum
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */

import java.util.*;

import static java.util.Arrays.binarySearch;

public class Fifteen {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            int left = i+1;
            int right = nums.length -1;
            int target = -nums[i];
            while (left<right){
                int sum = nums[left] + nums[right];
                if(target == sum){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //left < right 必须在前，否则会造成IndexOutOfBoundary
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left ++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    right--;
                }
                else if(sum<target)
                    left ++;
                else
                    right--;
            }
            while (nums[i] == nums[i+1] && i<nums.length -2) i++;
        }
        return res;
    }

    public static void main(String[] args){
        Fifteen fifteen = new Fifteen();
        System.out.println(fifteen.threeSum(new int[]{-1, 0, 1, 2, -4, 5}));
    }
}
