public class ThirtyOne {
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1])
                break;
        }
        if(i!=0) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i - 1])
                j++;
            int temp = nums[j - 1];
            nums[j - 1] = nums[i - 1];
            nums[i - 1] = temp;
        }
        for(int j = i; j<(i + nums.length)/2; j++){
            int temp = nums[j];
            nums[j] = nums[nums.length -1-(j-i)];
            nums[nums.length -1-(j-i)] = temp;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,3,2};
        ThirtyOne thirtyOne = new ThirtyOne();
        thirtyOne.nextPermutation(nums);
        for (int each: nums)
            System.out.print(each+" ");
    }
}
