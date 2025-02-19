import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] lst;
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lst = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
        Arrays.sort(lst);
        int count = 0;
        int left = 0;
        int right = N-1;
        while (left<right) {
            if (lst[left] + lst[right] == X) {
                left++;
                right--;
                count++;
            } else if (lst[left] + lst[right]<=X) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}