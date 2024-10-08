import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int res = N/4;
        for (int i=1 ; i<=res ; i++ ){
            sb.append("long");
            sb.append(" ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}