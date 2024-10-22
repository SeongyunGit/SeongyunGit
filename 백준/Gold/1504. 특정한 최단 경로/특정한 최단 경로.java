import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int a;
    static int b;
    static int c;
    static int start;
    static int end;
    static int INF = 200000000;

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> quene = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        Arrays.fill(dist,INF);
        quene.add(new Node(start,0));
        dist[start]=0;
        while (!quene.isEmpty()) {
            Node now = quene.poll();

            if (now.cost>dist[now.idx]) continue;

            for (int i=0;i<graph[now.idx].size();i++) {
                Node next = graph[now.idx].get(i);
                int nextCost=next.cost+now.cost;
                if (nextCost<dist[next.idx]) {
                    dist[next.idx] = nextCost;
                    quene.add(new Node(next.idx,nextCost));
                }
            }
        }

    
        return dist[end];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i=0;i<N+1;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int answer1 = dijkstra(1,start) + dijkstra(start,end) + dijkstra(end,N);
        int answer2 = dijkstra(1,end) + dijkstra(end,start) + dijkstra(start,N);


        if (answer1>=INF && answer2>=INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answer1,answer2));
        }
    }
}

class Node {
    int idx;
    int cost;
    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}