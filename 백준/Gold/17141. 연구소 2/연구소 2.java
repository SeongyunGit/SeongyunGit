import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static Queue<int[]> queue;
    static ArrayList<position> virus = new ArrayList<>();
    static position[] route;
    static int answer = Integer.MAX_VALUE;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static void permutation(int count,int start) {
        if (count == M) {
            bfs();
            return;
        }
        for (int i=start;i<virus.size();i++) {
            route[count]= virus.get(i);
            permutation(count+1,i+1);
        }
    }

    static void bfs() {
        Queue<int[]> quene = new LinkedList<>();
        int[][] visited = new int[N][N];
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                visited[i][j]=-1;
            }
        }
        int co =0;
        for (int i=0;i<M;i++) {
            visited[route[i].y][route[i].x] = 0;
            quene.add(new int[]{route[i].y,route[i].x});
        }

        while (!quene.isEmpty()) {
            if (co>=answer) {
                return;
            }
            for (int i=0;i<quene.size();i++) {
                int[] arr = quene.poll();
                int nowA=arr[0];
                int nowB=arr[1];
                for (int j=0;j< dir.length;j++) {
                    int nextA = nowA + dir[j][0];
                    int nextB = nowB + dir[j][1];
                    if (0<=nextA && nextA<N && 0<=nextB && nextB<N && visited[nextA][nextB]==-1 && graph[nextA][nextB]!=1) {
                        visited[nextA][nextB] = visited[nowA][nowB]+1;
                        quene.add(new int[]{nextA,nextB});
                    }
                }
            }
        }
        boolean flag = true;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (graph[i][j]!=1 && visited[i][j]==-1)
                    flag = false;
                if (visited[i][j]>=0) {
                    co = Math.max(co, visited[i][j]);
                }
            }
        }
        if (flag==true) {
            answer = Math.min(answer,co);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                graph[i][j]=Integer.parseInt(st.nextToken());
                if (graph[i][j]==2) {
                    virus.add(new position(j,i));
                }
            }
        }

        route = new position[M];
        permutation(0,0);
        if (answer==Integer.MAX_VALUE){
            bw.write("-1");
        } else {
            bw.write(answer + "");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

class position {
    int x;
    int y;
    public position(int x,int y) {
        this.x = x;
        this.y = y;
    }
}