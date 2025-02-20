import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int X;
    static List<Node>[] graph;
    static int a;
    static int b;
    static int c;
    static int[] dist;
    static boolean[] visited;
    static List<Integer> lst;


    static void dijkstra(int start) {
        PriorityQueue<Node> quene = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        dist[start]=0;
        quene.add(new Node(start,0));

        while (!quene.isEmpty()) {
            Node now = quene.poll();

            if (now.cost>dist[now.idx]) continue;


            for (int i=0;i< graph[now.idx].size();i++) {
                Node next = graph[now.idx].get(i);
                if (now.cost+ next.cost<dist[next.idx]) {
                    dist[next.idx] = now.cost + next.cost;
                    quene.add(new Node(next.idx,dist[next.idx]));
                }
            }
        }
    }

    static void dijkstra1(int start) {
        PriorityQueue<Node> quene = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        int[] dist1 = new int[N+1];
        for (int i=0;i<N+1;i++) {
            dist1[i]=Integer.MAX_VALUE;
        }
        dist1[start]=0;
        quene.add(new Node(start,0));

        while (!quene.isEmpty()) {
            Node now = quene.poll();

            if (now.cost>dist1[now.idx]) continue;

            for (int i=0;i<graph[now.idx].size();i++) {
                Node next = graph[now.idx].get(i);
                if (now.cost + next.cost<dist1[next.idx]) {
                    dist1[next.idx] = now.cost + next.cost;
                    quene.add(new Node(next.idx,dist1[next.idx]));
                }
            }
        }
        lst.add(dist1[X]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i=0;i<N+1;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }
        dist = new int[N+1];
        for (int i=0;i<N+1;i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        dijkstra(X);
        lst = new ArrayList<>();
        for (int i=1;i<N+1;i++) {
            dijkstra1(i);
        }
        int answer=0;
        
        for (int i=1;i<N+1;i++) {
            if (answer<dist[i] + lst.get(i-1)) {
                answer = dist[i] + lst.get(i-1);
            }
        }
        System.out.println(answer);
    }
}

class Node {
    int idx;
    int cost;

    public Node(int idx,int cost) {
        this.idx= idx;
        this.cost= cost;
    }
}