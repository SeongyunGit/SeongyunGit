import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] mapping;
    static int time = 1;
    static int count;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static int dfs(int a, int b) {
        int count = 1;
        boolean[][] visited = new boolean[N][M];
        visited[a][b]=true;
        Queue<int[]> quene = new LinkedList<>();
        quene.add(new int[]{a,b});
        while (!quene.isEmpty()) {
            int[] arr = quene.poll();
            int i = arr[0];
            int j = arr[1];
            for (int k=0;k< dir.length;k++) {
                int ni = i + dir[k][0];
                int nj = j + dir[k][1];
                if (0<=ni && ni<N && 0<=nj && nj<M && mapping[ni][nj]!=0 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    quene.add(new int[]{ni,nj});
                    count+=1;
                }
            }
        }
        return count;
    }



    static void real(Stack<int[]> stack) {
        int co = 0;
        while (!stack.isEmpty()) {
            int[] arr =stack.pop();
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            mapping[a][b]=c;
            if (c!=0) {
                co++;
            }
        }
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (mapping[i][j]>0) {
                    if (co==dfs(i,j)) {
                        time++;
                        island();
                    }
                    else return;
                }
            }
        }
    }

    static void island() {
        Stack<int[]> stack = new Stack<>();
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (mapping[i][j]>0) {
                    count=0;
                    for (int k=0;k< dir.length;k++) {
                        int ni = i+dir[k][0];
                        int nj = j + dir[k][1];
                        if (0<=ni && ni<N && 0<=nj && nj<M && mapping[ni][nj]==0) {
                            count++;
                        }
                    }
                    int a = 0;
                    if (mapping[i][j]-count<0) {
                        a = 0;
                    }
                    else {
                        a = mapping[i][j]-count;
                    }
                    stack.add(new int[]{i,j,a});
                }
            }
        }
        real(stack);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mapping = new int[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                mapping[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        island();
        int co = 0;
        for (int i=0; i<N;i++) {
            for (int j=0; j<M ; j++) {
                if (mapping[i][j]>0) {
                    co++;
                }
            }
        }
        if (time==1) {
            System.out.println(0);
        } else if (co==0) {
            System.out.println(0);
        } else {
            System.out.println(time);
        }
    }
}

