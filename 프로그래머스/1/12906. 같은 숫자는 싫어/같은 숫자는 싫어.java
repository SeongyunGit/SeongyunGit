import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> lst = new ArrayList();
        int end = arr[0];
        lst.add(arr[0]);
        for (int i=0;i<arr.length;i++) {
            if (end != arr[i]) {
                lst.add(arr[i]);
            }
            end = arr[i];
        }
        int[] answer = new int[lst.size()];
        for (int i=0;i<lst.size();i++) {
            answer[i] = lst.get(i);
        }

        return answer;
    }
}