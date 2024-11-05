import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] mapping;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static void bfs(int a, int b) {
        Queue<int[]> quene = new LinkedList<>();
        Stack<int[]> stack = new Stack<>();
        quene.add(new int[]{a,b});
        stack.add(new int[]{a,b});
        int total=0;
        visited[a][b]=true;
        total += mapping[a][b];
        while (!quene.isEmpty()) {
            int[] now = quene.poll();
            int nowA = now[0];
            int nowB = now[1];
            for (int k=0;k< dir.length;k++) {
                int ni = nowA + dir[k][0];
                int nj = nowB + dir[k][1];
                if (0<=ni && ni<N && 0<=nj && nj<N && L<=Math.abs(mapping[nowA][nowB]-mapping[ni][nj]) && Math.abs(mapping[nowA][nowB]-mapping[ni][nj])<=R && !visited[ni][nj]) {
                    visited[ni][nj]=true;
                    total += mapping[ni][nj];
                    stack.add(new int[]{ni,nj});
                    quene.add(new int[]{ni,nj});
                }
            }
        }

        if (stack.size()!=1) {
            total=total/stack.size();
            for (int l=0;l<stack.size();l++) {
                int x = stack.get(l)[0];
                int y = stack.get(l)[1];
                mapping[x][y]=total;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        mapping = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                mapping[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int result =0;
        while (true) {
            int count=0;
            visited = new boolean[N][N];
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    if (!visited[i][j]) {
                        bfs(i,j);
                        count++;

                    }
                }
            }
            if (count==N*N) break;

            result++;
        }
        System.out.println(result);
    }
}

