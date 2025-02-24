import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = 0;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Node> quene = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] graph = new int[n][m];
        graph[0][0] = 1;
        quene.add(new Node(0,0,1));
        visited[0][0]= true;
        while (!quene.isEmpty()) {
            Node now = quene.poll();
            for (int i=0;i<dir.length;i++) {
                int ni = now.x + dir[i][0];
                int nj = now.y + dir[i][1];
                int count = now.count;
                if (0<=ni && ni<n && 0<=nj && nj<m && !visited[ni][nj] && maps[ni][nj]==1) {
                    graph[ni][nj]= count+1;
                    visited[ni][nj]=true;
                    quene.add(new Node(ni,nj,now.count+1));
                }
            }
        }
        if (graph[n-1][m-1]==0) {
            return -1;
        } else {
            return graph[n-1][m-1];
        }
    }
}
class Node{
    int x;
    int y;
    int count;
    Node(int x, int y, int count) {
        this.x =x;
        this.y = y;
        this.count = count;
    }
}