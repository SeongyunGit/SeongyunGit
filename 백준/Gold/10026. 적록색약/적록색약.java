import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] graph;
    static boolean[][] visited;
    static StringTokenizer st;
    static String s;
    static int count;
    static int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    static int count1;

    static void bfs(int i,int j,String S) {
        Queue<int[]> quene = new LinkedList<>();
        visited[i][j]=true;
        quene.add(new int[]{i,j});

        while (!quene.isEmpty()) {
            int[] arr = quene.poll();
            int a = arr[0];
            int b = arr[1];
            for (int k=0;k<dir.length;k++) {
                int ni = a+dir[k][0];
                int nj = b+dir[k][1];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && S.equals(String.valueOf(graph[ni][nj]))) {
                    visited[ni][nj] = true;
                    quene.add(new int[]{ni, nj});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];

        for (int i=0;i<N;i++) {
            s= br.readLine();
            for (int j=0;j<N;j++) {
                graph[i][j]= s.charAt(j);
            }
        }
        count=0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (graph[i][j]=='R' && !visited[i][j]) {
                    String R = "R";
                    bfs(i,j, R);
                    count++;
                }
                if (graph[i][j]=='G' && !visited[i][j]) {
                    String G = "G";
                    bfs(i,j,G);
                    count++;
                }
                if (graph[i][j]=='B' && !visited[i][j]) {
                    String B = "B";
                    bfs(i,j,B);
                    count++;
                }

            }
        }
        count1=0;
        visited=new boolean[N][N];
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (graph[i][j]=='R') {
                    graph[i][j]='G';
                }
            }
        }
        for (int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'G' && !visited[i][j]) {
                    String G = "G";
                    bfs(i, j, G);
                    count1++;
                }
                if (graph[i][j] == 'B' && !visited[i][j]) {
                    String B = "B";
                    bfs(i, j, B);
                    count1++;
                }


            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count);
        sb.append(" ");
        sb.append(count1);

        System.out.println(sb);
    }
}