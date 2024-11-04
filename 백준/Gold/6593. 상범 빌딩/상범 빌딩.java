import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int R;
    static int C;
    static char[][][] building;
    static int[][][] visited;
    static int x;
    static int y;
    static int z;
    static int[][] dir = {{1,0,0},{-1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};

    static int bfs(Queue<int[]> quene) {
        while (!quene.isEmpty()) {
            int[] arr = quene.poll();
            x = arr[0];
            y = arr[1];
            z = arr[2];
            for (int l = 0; l < dir.length; l++) {
                int ni = x + dir[l][0];
                int nj = y + dir[l][1];
                int nz = z + dir[l][2];
                if (0 <= ni && ni < L && 0 <= nj && nj < R && 0 <= nz && nz < C && visited[ni][nj][nz] == 0 && building[ni][nj][nz] == '.') {
                    visited[ni][nj][nz] = visited[x][y][z] + 1;
                    quene.add(new int[]{ni, nj, nz});
                }
                if (0 <= ni && ni < L && 0 <= nj && nj < R && 0 <= nz && nz < C && visited[ni][nj][nz] == 0 && building[ni][nj][nz] == 'E') {
                    visited[ni][nj][nz] = visited[x][y][z] + 1;
                    return visited[ni][nj][nz]-1;
                }
            }
        }
        return 0;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L==0 && R==0 && C==0)
                break;
            building = new char[L][R][C];
            visited = new int[L][R][C];
            Queue<int[]> quene = new LinkedList<>();
            for (int i=0;i<L;i++) {
                for (int j=0;j<R;j++) {
                    String line = br.readLine();
                    for (int k=0;k<C;k++) {
                        building[i][j][k] = line.charAt(k);
                        if (building[i][j][k]=='S') {
                            visited[i][j][k] = 1;
                            quene.add(new int[]{i,j,k});
                        }
                    }
                }
                br.readLine();
            }
            int result = bfs(quene);
            if (result>0) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }
}