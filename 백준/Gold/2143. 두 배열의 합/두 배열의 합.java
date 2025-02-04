import java.io.*;
import java.util.*;

public class Main {
    static Long T;
    static int N;
    static int[] Nst;
    static int M;
    static int[] Mst;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());
        N = Integer.parseInt(br.readLine());
        Nst = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            Nst[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        Mst = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            Mst[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=1;i<N;i++) {
            Nst[i] += Nst[i-1];
        }
        for (int i=1;i<M;i++) {
            Mst[i] += Mst[i-1];
        }

        int aSize = N*(N+1)/2;
        int bSize = M*(M+1)/2;
        long[] aSum = new long[aSize];
        long[] bSum = new long[bSize];

        int idx = 0;
        for(int i=0;i<N;i++) {
            for (int j=i;j<N;j++) {
                int av = Nst[j];
                if (i>0) av -= Nst[i-1];
                aSum[idx++] = av;
            }
        }

        idx = 0;
        for (int i=0;i<M;i++) {
            for (int j=i;j<M;j++) {
                int bv = Mst[j];
                if (i>0) bv -= Mst[i-1];
                bSum[idx++] = bv;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);
        int left = 0;
        int right = bSize - 1;
        long count = 0;
        while (left<aSize && right > -1) {
            long asv = aSum[left], bsv = bSum[right];
            long sum = asv + bsv;
            if (sum == T) {
                long ac = 0, bc = 0;
                while (left<aSize && asv == aSum[left]) {
                    left++;
                    ac++;
                }
                while (right>-1 && bsv == bSum[right]) {
                    right--;
                    bc++;
                }
                count += ac*bc;
            }
            if (sum > T) {
                right--;
            } else if (sum<T) {
                left++;
            }
        }

        System.out.println(count);

    }
}