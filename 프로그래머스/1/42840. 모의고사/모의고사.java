import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0, 0, 0};
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i=0; i<answers.length; i++) {
            if (num1[i%5] == answers[i]) {
                answer[0]++;
            } if (num2[i%8] == answers[i]) {
                answer[1]++;
            } if (num3[i%10] == answers[i]) {
                answer[2]++;
            }
        }
        int maxim = 0;
        for (int i =0;i<3;i++) {
            if (maxim < answer[i]) {
                maxim = answer[i];
            }
        }
        System.out.println(maxim);
        List<Integer> lst = new ArrayList<>();
        for (int i=0;i<3;i++) {
            if (maxim == answer[i]) {
                System.out.println(i+1);
                lst.add(i+1);
            }
        }
        int[] ans = new int[lst.size()];
        for (int i=0;i<lst.size();i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }
}