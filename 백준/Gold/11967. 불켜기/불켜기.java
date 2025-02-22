import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int a;
    static int b;
    static int x;
    static int y;
    static ArrayList<Node> graph[][];
    static boolean[][] visited;
    static boolean[][] light;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int answer = 1;
    static void bfs(int st, int st1) {
        visited = new boolean[N+1][N+1];
        light = new boolean[N+1][N+1];
        visited[st][st1] = true;
        light[st][st1] = true;
        Queue<Node> quene = new LinkedList<>();
        quene.add(new Node(st,st1));
        while(!quene.isEmpty()) {
            Node now = quene.poll();
            if (!graph[now.i][now.j].isEmpty()) {
                visited = new boolean[N+1][N+1];
                visited[now.i][now.j]= true;
                for (Node node : graph[now.i][now.j]) {
                    if (!light[node.i][node.j]) {
                        light[node.i][node.j] = true;
                        answer++;
                    }
                }
                graph[now.i][now.j].clear();
            }

            for (int i=0;i< dir.length;i++) {
                int ni = now.i + dir[i][0];
                int nj = now.j + dir[i][1];
                if (1<=ni && ni<N+1 && 1<=nj && nj<N+1 && !visited[ni][nj] && light[ni][nj]) {
                    visited[ni][nj] = true;
                    quene.add(new Node(ni,nj));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1][N+1];
        for (int i=1;i<=N ;i++) {
            for (int j=1;j<=N;j++) {
                graph[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[a][b].add(new Node(x,y));
        }
        bfs(1,1);
        System.out.println(answer);
    }
}
class Node {
    int i;
    int j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}