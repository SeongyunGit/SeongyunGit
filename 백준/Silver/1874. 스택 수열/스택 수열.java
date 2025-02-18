import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int N;
    static int A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean isTrue = true;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int current = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            while (current <= N) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }

            if (!stack.isEmpty() && stack.peek() == N) {
                stack.pop();
                sb.append("-\n");
            } else {
                isTrue = false;
                break;
            }
        }

        if (isTrue) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}