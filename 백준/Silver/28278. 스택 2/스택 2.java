import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M=Integer.parseInt(st.nextToken());
            if (M==1) {
                int A = Integer.parseInt(st.nextToken());
                stack.push(A);
            }
            if (M==2) {
                if (!stack.empty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            }
            if (M==3) {
                System.out.println(stack.size());
            }
            if (M==4) {
                if (!stack.empty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            }
            if (M==5) {
                if (!stack.empty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}