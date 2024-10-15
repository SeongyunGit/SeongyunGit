import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] graph;
    static boolean[][] visited;
    static int count=0;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};


    static int bfs(int x,int y) {
        count++;
        visited[x][y]=true;
        graph[x][y]=1;
        Queue<int[]> quene = new LinkedList<>();
        quene.add(new int[] {x,y});
        while (!quene.isEmpty()) {
            int[] arr = quene.poll();
            int nowA = arr[0];
            int nowB = arr[1];

            for (int i=0;i< dir.length;i++) {
                int ni = nowA + dir[i][0];
                int nj = nowB + dir[i][1];
                if (0<=ni && ni<N && 0<=nj && nj<M && !visited[ni][nj] && graph[ni][nj]==0) {
                    visited[ni][nj]=true;
                    graph[ni][nj]=1;
                    count++;
                    quene.add(new int[] {ni,nj});
                }
            }
        }
        return count;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                graph[i][j]=0;
            }
        }



        for (int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            for (int j=y;j<y1;j++) {
                for (int k=x;k<x1;k++) {
                    graph[j][k]=1;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (graph[i][j]==0) {
                    count = 0;
                    int data = bfs(i,j);
                    answer.add(data);
                }
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<answer.size();i++) {
            sb.append(answer.get(i));
            sb.append(" ");
        }
        System.out.println(answer.stream().count());
        System.out.println(sb);


    }
}