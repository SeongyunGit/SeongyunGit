import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] S = s.split(" ");
        int[] nums = new int[S.length];
        for (int i =0;i<S.length;i++) {
            nums[i] = Integer.parseInt(S[i]);
        }
        Arrays.sort(nums);
        answer = nums[0] + " " + nums[nums.length - 1]; 
        return answer;
    }
}