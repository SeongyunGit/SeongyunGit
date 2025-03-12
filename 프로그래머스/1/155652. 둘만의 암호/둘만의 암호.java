import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        int[] lst = new int[s.length()];
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            lst[i] = s.charAt(i) - 'A';
        }
        
        skip = skip.toUpperCase();
        Set<Integer> skipping = new HashSet<>();
        for (int i = 0; i < skip.length(); i++) {
            skipping.add(skip.charAt(i) - 'A');
        }

        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int current = lst[i];
            int count = 0;
            
            while (count < index) {
                current = (current + 1) % 26;
                if (!skipping.contains(current)) {
                    count++;
                }
            }
            
            answer[i] = current;
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append((char)(answer[i] + 'A'));
        }
        
        return ans.toString().toLowerCase();
    }
}