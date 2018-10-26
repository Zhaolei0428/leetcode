import java.util.*;

public class Fourty {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        int sum = 1;
        while (end>0 && candidates[end-1] == candidates[end]){
            end --;
            sum++;
        }
        while (sum-- >= 0 && target>=0) {
            findResult(candidates, end-1, target, newList);
            target = target - candidates[end];
            newList.add(candidates[end]);
        }
    }

    public static void main(String[] args){
        Fourty fourty = new Fourty();
        int[] candi = new int[]{2,5,2,1,2};
        List<List<Integer>> result = fourty.combinationSum2(candi, 5);
        System.out.println(result);
    }
}
