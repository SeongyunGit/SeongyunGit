import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> quene = new PriorityQueue<>();
        for (int x : scoville) {
            quene.add(x);
        }
        while (quene.size()>1) {
            if (quene.peek() >= K) {
                return count;
            }
            int before = quene.poll();
            int after = quene.poll();
            int total = before + (after * 2);
            count++;
            quene.add(total);
            if (quene.peek() >= K) {
                return count;
            }
        }
        if (!quene.isEmpty()) {
            if (quene.poll()>=K) {
                return count+1;
            }
        } else {
            return -1;   
        }
        return -1;
    }
}