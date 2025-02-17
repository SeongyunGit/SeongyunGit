import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int[] lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            lst = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N ; j++) {
                lst[j] = Integer.parseInt(st.nextToken());
            }

            long total = 0;
            int maxim = lst[N-1];
            for (int k=N-2;k>-1;k--) {
                if (maxim >= lst[k]) {
                    total += maxim - lst[k];
                } else {
                    maxim = lst[k];
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}