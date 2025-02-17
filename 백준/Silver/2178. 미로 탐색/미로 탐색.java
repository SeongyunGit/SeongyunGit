import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static void bfs(int a, int b) {
        visited = new boolean[N][M];
        visited[a][b] = true;
        Queue<Node> quene = new LinkedList<>();
        quene.add(new Node(a,b, 1));
        while (!quene.isEmpty()) {
            Node node = quene.poll();
            int x = node.x;
            int y = node.y;
            int count = node.count;
            for (int i=0;i<dir.length;i++) {
                int ni = x + dir[i][0];
                int nj = y + dir[i][1];
                if (0<=ni && ni<N && 0<=nj && nj<M && !visited[ni][nj] && graph[ni][nj]==1) {
                    if (ni==N-1 && nj==M-1) {
                        System.out.println(count+1);
                        return;
                    }
                    visited[ni][nj]=true;
                    quene.add(new Node(ni,nj, count+1));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i=0;i<N;i++) {
            String s = br.readLine();
            for (int j=0;j<M;j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0,0);

    }
}
class Node {
    int x;
    int y;
    int count;
    Node (int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
