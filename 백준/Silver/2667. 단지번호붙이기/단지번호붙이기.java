import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int count=0;
    static List<Integer> answer = new ArrayList<>();
    static int totalApart;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static void bfs(int x, int y) {
        visited[x][y]=true;
        Queue<int[]> quene = new LinkedList<>();
        quene.add(new int[]{x,y});
        while (!quene.isEmpty()) {
            int[] arr = quene.poll();
            int nowA=arr[0];
            int nowB=arr[1];
            for (int i=0;i< dir.length;i++) {
                int ni = nowA + dir[i][0];
                int nj = nowB + dir[i][1];
                if (0<=ni && ni<N && 0<=nj && nj<N && !visited[ni][nj] && graph[ni][nj]==1) {
                    visited[ni][nj]=true;
                    quene.add(new int[]{ni,nj});
                    count++;
                }
            }

        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (graph[i][j]==1 && !visited[i][j]) {
                    totalApart++;
                    count++;
                    bfs(i,j);
                    answer.add(count);
                    count=0;
                }
            }
        }
        System.out.println(totalApart);
        Collections.sort(answer);
        for (int i=0;i<answer.size();i++) {
            System.out.println(answer.get(i));
        }
    }
}