import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class FourtyFive {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int front = 1;
        int end = nums[0];
        int step = 1;
        while (end < nums.length -1) {
            int newEnd = end + 1;
            for(int i = front; i <= end; i++) {
               if(i+nums[i] > newEnd)
                   newEnd = i + nums[i];
            }
            front = end + 1;
            end = newEnd;
            step ++;
        }
        return step;
    }


    public static void main(String[] args) {
        FourtyFive fourtyFive = new FourtyFive();
        int[] nums = {2,3,1,1,4};
        System.out.println(fourtyFive.jump(nums));
    }
}
