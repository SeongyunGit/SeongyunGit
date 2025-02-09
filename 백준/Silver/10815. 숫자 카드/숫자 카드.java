import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] M;
    static int A;
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0;i<N;i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }
        A = Integer.parseInt(br.readLine());
        B = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<A;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(M);

        Map<Integer, Integer> dict = new HashMap<>();
        for (int num:M) {
            dict.put(num, dict.getOrDefault(num,0) +1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<A;i++) {
            if (dict.containsKey(B[i])) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);

    }
}