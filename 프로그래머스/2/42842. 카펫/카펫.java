import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        Integer[] answer = {};
        answer = new Integer[2];
        for (int i=1;i<=yellow/2+1;i++) {
            if (yellow%i==0) {
                int y = yellow/i;
                if (brown == y*2 + i*2 + 4) {
                    answer[0] = i+2;
                    answer[1] = y+2;
                }      
            }
        }
        Arrays.sort(answer, Comparator.reverseOrder());
        int[] arr = new int[2];
        for (int i=0;i<2;i++) {
            arr[i] = answer[i];
        }
        return arr;
    }
}