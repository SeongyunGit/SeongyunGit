import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> quene = new LinkedList<>();
        quene.add(0);
        for (int i=0;i<numbers.length;i++) {
            int size = quene.size();
            for (int j=0;j<size;j++) {
                int sum = quene.poll();
                quene.add(sum+numbers[i]);
                quene.add(sum-numbers[i]);
            }
        }
        while (!quene.isEmpty()) {
            if(quene.poll() == target) {
                answer++;
            } 
        }
        
        return answer;
    }
}