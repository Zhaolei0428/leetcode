import java.util.Arrays;

public class Sixteen {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - closest);
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length -1;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(target - sum);
                if(diff > currentDiff){
                    diff = currentDiff;
                    closest = sum;
                }
                if(sum<target)
                    left ++;
                else
                    right--;
            }
        }
        return closest;
    }
}
