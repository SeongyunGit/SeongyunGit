import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public boolean[] visited;
    public int answer = 0;
    public int total = 0;
    public void bfs(int start) {
        visited[start] = true;
        Queue<Node> quene = new LinkedList();
        quene.add(new Node(start, 0));
        while (!quene.isEmpty()) {
            Node now = quene.poll();
            int now1 = now.now;
            int count = now.count;
            for (int j=0;j<graph.get(now1).size();j++) {
                if (!visited[graph.get(now1).get(j)]) {
                    visited[graph.get(now1).get(j)] = true;
                    quene.add(new Node(graph.get(now1).get(j), count+1));
                    if (count+1>answer) {
                        answer = count+1;
                        total = 1;
                    } else if (count+1 == answer) {
                        total++;
                    }
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] i : edge) {
            int v = i[0];
            int s = i[1];
            graph.get(v).add(s);
            graph.get(s).add(v);
        }
        visited = new boolean[n+1];
        bfs(1);
        
        
        return total;
    }
}
class Node {
    int now;
    int count;
    Node(int now, int count) {
        this.now = now;
        this.count = count;
    }
}