import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int idx = 0;
        for (int i=people.length - 1;i>=idx;i--) {
            if (people[i] + people[idx] <= limit) {
                answer++;
                idx++;
            } else {
                answer++;
            }
        }
        return answer;
    }
}