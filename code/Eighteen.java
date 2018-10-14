import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question 4Sum
 Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:

 The solution set must not contain duplicate quadruplets.

 Example:

 Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class Eighteen {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++)
        {
            for (int j=i+1; j<nums.length-2; j++){
                int left = j+1;
                int right = nums.length -1;
                int remainder = target-nums[i]-nums[j];
                while (left<right){
                    int sum = nums[left] + nums[right];
                    if(remainder == sum){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //left < right 必须在前，否则会造成IndexOutOfBoundary
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left ++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        right--;
                    }
                    else if(sum<remainder)
                        left ++;
                    else
                        right--;
                }
                while (j<nums.length-2 && nums[j] == nums[j+1]) j++;
            }
            while (nums[i] == nums[i+1] && i<nums.length -3) i++;
        }
        return res;
    }
}
