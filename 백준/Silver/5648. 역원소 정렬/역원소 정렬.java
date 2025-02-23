import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        int idx=0;
        while (true) {
            if (st.hasMoreTokens()) {
                StringBuilder input = new StringBuilder(st.nextToken());
                arr[idx++] = Long.parseLong(input.reverse().toString());
                if (idx==n) break;
            } else {
                st = new StringTokenizer(br.readLine());
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for (long a : arr) {
            sb.append(a + "\n");
        }
        System.out.println(sb);
    }
}