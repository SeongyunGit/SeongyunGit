import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int start;
    static boolean[] visited;
    static StringTokenizer st;
    static int[] dist;
    static List<Node>[] graph;
    static void dijkstra(int start) {
        PriorityQueue<Node> quene = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        dist[start]=0;
        quene.add(new Node(start,0));

        while (!quene.isEmpty()) {
            Node now = quene.poll();


            if (visited[now.idx]) continue;
            visited[now.idx] = true;

            for (int i=0;i<graph[now.idx].size();i++) {
                Node next = graph[now.idx].get(i);
                if (!visited[next.idx] && now.cost + next.cost < dist[next.idx]) {
                    dist[next.idx] = now.cost + next.cost;
                    quene.add(new Node(next.idx,dist[next.idx]));
                }

            }

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new List[N+1];

        for (int i=0;i<N+1;i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }

        dist = new int[N+1];
        visited = new boolean[N+1];

        for (int i=0;i<N+1;i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        dijkstra(start);
        for (int i=1; i<N+1;i++) {
            if (dist[i]==Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }




    }
}
class Node {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

}