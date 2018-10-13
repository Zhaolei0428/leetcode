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

//    public List<List<Integer>> threeSum(int[] nums) {
//        ArrayList<List<Integer>> satistiedList = new ArrayList<>();
//        Set<List<Integer>> satistiedSet = new HashSet<>();
//        Map<Integer, Integer> numMap = new HashMap<>();
//        for(int num: nums){
//            if(numMap.get(num) == null)
//                numMap.put(num, 1);
//            else
//                numMap.put(num,numMap.get(num)+1);
//        }
//        if(nums.length < 3) return satistiedList;
//        Arrays.sort(nums);
//        int len = nums.length;
//        for(int i=0; i< len -2;i++){
//            if(nums[i] > 0) break;
//            for(int j=i+1; j<nums.length-1; j++){
//                int target = -(nums[i] + nums[j]);
//                if(target < nums[j]) break;
//                if(numMap.get(target)!=null){
//                    int count=numMap.get(target);
//                    if(nums[j] == target) {
//                        count--;
//                        if(nums[i] == target)
//                            count --;
//                    }
//                    if(count>0)
//                        satistiedSet.add(Arrays.asList(nums[i], nums[j], target));
//                }
//            }
//            while (i < len -2 && nums[i] == nums[i+1]) i++;
//        }
//        satistiedList = new ArrayList<>(satistiedSet);
//        return satistiedList;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> sl = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            sl.put(nums[i], i);      // overwriting i to hold the latest position of repeating number
        for(int i=0;i<nums.length-2;i++)
        {
            if(nums[i] > 0) break;
            for(int j=i+1;j<nums.length-1;j++)
            {
                int target = 0-nums[i]-nums[j];
                if(target < nums[j]) break;
                if(sl.containsKey(target) && sl.get(target)>j)
                {
                    j=sl.get(nums[j]);
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
            i=sl.get(nums[i]);  // To remove duplicates
        }
        return res;
    }

    public int binarySearch(int[] a,int fromIndex,int toIndex,int value){
        int low=fromIndex;
        int high=toIndex;
        while(low<=high){
            int mid=(low+high)/2;
            int midVal=a[mid];
            if(midVal<value)
                low=mid+1;
            else if(midVal>value)
                high=mid-1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        Fifteen fifteen = new Fifteen();
        System.out.println(fifteen.threeSum(new int[]{-1, 0, 1, 2, -4, 5}));
    }
}
