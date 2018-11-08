import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FourtySix {
    private List<List<Integer>> result;
    Deque<Integer> deque;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        deque = new ArrayDeque<>();
        for(int num: nums)
            deque.add(num);
        if(nums.length == 0)
            return result;
        realPremute(nums, new ArrayList<>());
        return result;
    }

    public void realPremute(int[] nums, ArrayList<Integer> list) {
        if(deque.isEmpty())
            result.add((List<Integer>) list.clone());
        int len = deque.size();
        while (len-- > 0) {
            int num = deque.poll();
            list.add(num);
            realPremute(nums, list);
            deque.add(num);
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args) {
        FourtySix fourtySix = new FourtySix();
        int[] nums = {1,2,3,4};
        System.out.println(fourtySix.permute(nums));
    }

}
