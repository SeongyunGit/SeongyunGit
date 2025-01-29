import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] lst;
    static boolean[] visited;

    static boolean isOk() {
        int count = 0;
        for (int i = 0 ; i<lst.length;i++) {
            if (lst[i] == 0) {
                count++;
            }
            if (count>=K) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        lst = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<lst.length;i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        while (isOk()) {
            int temp = lst[lst.length-1];
            for (int i = lst.length - 1; i>0;i--) {
                lst[i] = lst[i-1];
            }
            lst[0] = temp;
            for (int i = visited.length-1;i>0;i--) {
                visited[i] = visited[i-1];
            }
            visited[0] = false;
            visited[N-1] = false;

            for (int i = visited.length;i>0;i--) {
                if (visited[i-1] && !visited[i] && lst[i]>=1) {
                    lst[i]--;
                    visited[i] = true;
                    visited[i-1] = false;
                }
            }

            if (lst[0] > 0) {
                visited[0] = true;
                lst[0]--;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}