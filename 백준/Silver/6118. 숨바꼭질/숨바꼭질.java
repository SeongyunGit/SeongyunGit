import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int a;
    static int b;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static List<Node> lst;
    static int answer;
    static int count;
    static void bfs(int start) {
        visited = new boolean[N+1];
        visited[start] = true;
        Queue<Node> quene = new LinkedList<>();
        quene.add(new Node(start,0));
        while (!quene.isEmpty()) {
            Node now = quene.poll();
            for (int i=0; i<graph[now.i].size();i++) {
                Node next = (Node) graph[now.i].get(i);
                if (!visited[next.i]) {
                    visited[next.i] = true;
                    lst.add(new Node(next.i,now.count+1));
                    quene.add(new Node(next.i, now.count+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,0));
            graph[b].add(new Node(a,0));
        }
        lst = new ArrayList<>();
        lst.add(new Node(0,0));
        bfs(1);
        for (Node node : lst) {
            if (answer < node.count) {
                answer = node.count;
            }
        }
        int result = Integer.MAX_VALUE;
        for (Node node : lst) {
            if (answer == node.count) {
                count++;
                if (result>node.i) {
                    result = node.i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result).append(" ").append(answer).append(" ").append(count);
        System.out.println(sb);
    }
}
class Node{
    int i;
    int count;
    Node(int i, int count) {
        this.i = i;
        this.count = count;
    }
}