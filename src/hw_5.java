import java.util.ArrayList;
import java.util.HashSet;

public class hw_5 {
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,2,1,6,8};
        int[] nums2 = {5,3,2,1,6,4,7,5,9};

        HashSet<ArrayList<Integer>> SetOfEl1 = getSet(nums1);
        HashSet<ArrayList<Integer>> SetOfEl2 = getSet(nums2);

        SetOfEl2.retainAll(SetOfEl1);

        int max = 0;

        for (ArrayList<Integer> i : SetOfEl2){
            if (max < i.size()){
                max = i.size();
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (ArrayList<Integer> i : SetOfEl2){
            if (i.size() == max){
                for (int j : i){
                    list.add(j);
                }
            }
        }
        System.out.printf("Повторяющийся подмассив с максимальной длиной равной %d - это %s", max, list);
    }
    private static HashSet<ArrayList<Integer>> getSet(int[] array) {
        HashSet<ArrayList<Integer>> tempSet = new HashSet<>();
        for (int n = 1; n <= array.length; n++) {
            for (int i = 0; i < array.length; i++) {
                ArrayList<Integer> tempArray = new ArrayList<>();
                for (int j = i; j < i + n; j++) {
                    if (j >= array.length) break;
                    tempArray.add(array[j]);
                }
                tempSet.add(tempArray);
            }
        }
        return tempSet;
    }
}
