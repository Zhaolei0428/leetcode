import java.util.*;

public class FourtyNine {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!groupMap.containsKey(key)){
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                groupMap.put(key, arrayList);
            }
            else {
                groupMap.get(key).add(str);
            }
        }
        return new ArrayList<>(groupMap.values());
    }

    public static void main(String[] args) {
        FourtyNine fourtyNine = new FourtyNine();
        String[] strs = {"cat", "cta", "dog", "god"};
        List<List<String>> result = fourtyNine.groupAnagrams(strs);
        for(List<String> list: result) {
            for(String str: list) {
                System.out.print(str);
            }
            System.out.println();
        }
    }
}
