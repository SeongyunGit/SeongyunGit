import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] lst;
    static int[] l;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lst = new int[N];
        l = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0;i<N;i++) {
            lst[i] = l[i] = Integer.parseInt(st.nextToken());
        }
        map = new HashMap<>();
        Arrays.sort(lst);
        int check = 0;
        for (int i:lst) {
            if (!map.containsKey(i)) {
                map.put(i, check);
                check ++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i:l) {
            sb.append(map.get(i) + " ");
        }
        System.out.println(sb);
    }
}