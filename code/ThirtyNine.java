import java.util.ArrayList;
import java.util.List;

public class ThirtyNine {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        findResult(candidates, candidates.length-1, target, new ArrayList<Integer>());
        return result;
    }

    public void findResult(int[] candidates, int end, int target, ArrayList<Integer> list){
        ArrayList<Integer> newList = (ArrayList<Integer>)list.clone();
        if(target == 0) {
            result.add(newList);
            return;
        }
        if(end == -1){
            return;
        }
        while (target>=0){
            findResult(candidates, end-1, target, newList);
            target = target - candidates[end];
            newList.add(candidates[end]);
        }
    }

    public static void main(String[] args){
        ThirtyNine thirtyNine = new ThirtyNine();
        int[] candi = new int[]{2,3,6,7};
        List<List<Integer>> result = thirtyNine.combinationSum(candi, 7);
        System.out.println(result);
    }
}
