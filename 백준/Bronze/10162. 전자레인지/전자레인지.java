import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        int c = 0;
        boolean is_true = true;
        if (N/300 > 0) {
            a = N/300;
            N = N%300;
        } if (N/60 > 0) {
            b = N/60;
            N = N%60;
        } if (N/10 > 0) {
            c = N/10;
            N = N%10;
        }
        if (N==0) {
            System.out.print(a + " ");
            System.out.print(b + " ");
            System.out.print(c);
        } else {
            System.out.println(-1);
        }
    }
}