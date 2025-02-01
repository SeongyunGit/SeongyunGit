import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    static int N;
    static int M;
    static int total = Integer.MAX_VALUE;
    static int[][] graph;
    static Stack<Num> l = new Stack<>();
    static List<Num> chicken;
    static List<Num> person;


    public static void permutation(int num,int size) {
        if (l.size() == size) {
            makingGraph(l);
            return;
        }
        for (int i = num; i< chicken.size(); i++) {
            l.add(chicken.get(i));
            permutation(i+1, size);
            l.pop();

        }
    }

    public static void makingGraph(List<Num> l) {
        int result = 0;
        for (int i=0;i<person.size();i++) {
            int person_min = Integer.MAX_VALUE;
            for (int j = 0; j<M;j++) {
                person_min = min(person_min, abs(person.get(i).a - l.get(j).a) + abs(person.get(i).b - l.get(j).b));
            }
            result += person_min;
        }
        total = min(total, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        person = new ArrayList<>();
        graph = new int[N][N];
        for (int i = 0 ; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j]==2) {
                    chicken.add(new Num(i,j));
                } else if (graph[i][j]==1) {
                    person.add(new Num(i,j));
                }
            }
        }
        permutation(0, M);

        System.out.println(total);
    }
}
class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
class Num {
    int a;
    int b;
    public Num(int a, int b) {
        this.a = a;
        this.b = b;
    }
}