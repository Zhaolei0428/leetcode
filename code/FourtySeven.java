import java.util.*;

public class FourtySeven {
    private List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0)
            return result;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        realPremute(nums, new ArrayList<>(), visited);
        return result;
    }

    public void realPremute(int[] nums, List list, boolean[] visited) {
        if(list.size() == nums.length)
            result.add(new ArrayList<>(list));
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                realPremute(nums, list,visited);
                visited[i] = false;
                list.remove(list.size() -1);
                while (i<nums.length-1 && nums[i+1] == nums[i]) i++;
            }
        }
    }

    public static void main(String[] args) {
        FourtySeven fourtySeven = new FourtySeven();
        int[] nums = {1,1,2};
        System.out.println(fourtySeven.permuteUnique(nums));
    }
}
