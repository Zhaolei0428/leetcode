/**
 * Question Find First Last Position of Element in Sorted Array
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */

public class ThirtyFour {
    public int[] searchRange(int[] nums, int target) {
        int[] lr = new int[]{-1,-1};
        if(nums.length == 0)
            return lr;
        if(nums[0] == target)
            lr[0] = 0;
        else {
            int left = 1;
            int right = nums.length-1;
            while (left<=right){
                int mid = (left + right)/2;
                if(nums[left] == target && nums[left-1]!=target) {
                    lr[0] = left;
                    break;
                }
                if(target>nums[mid])
                    left=mid+1;
                else if(target<nums[mid])
                    right = mid -1;
                else
                    right = mid;
            }
        }
        if(nums[nums.length-1] == target)
            lr[1] = nums.length-1;
        else {
            int left = 0;
            int right = nums.length-2;
            while (left<=right){
                int mid = (left + right)/2;
                if(nums[right] == target && nums[right+1]!=target) {
                    lr[1] = right;
                    break;
                }
                if(target>nums[mid])
                    left=mid+1;
                else if(target<nums[mid])
                    right = mid -1;
                else{
                    if(mid+1 != right)
                        left = mid;
                    else
                        right = mid;
                }
            }
        }
        return lr;
    }

    public static void main(String[] args){
        ThirtyFour thirtyFour = new ThirtyFour();
        int[] nums  = new int[]{5, 7, 7, 8, 8, 8, 8, 8, 8, 9, 10};
        int[] result = thirtyFour.searchRange(nums, 9);
        for(int num: result)
            System.out.println(num);
    }
}
