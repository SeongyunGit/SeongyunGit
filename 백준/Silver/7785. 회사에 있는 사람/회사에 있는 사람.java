import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<String, String> lst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lst = new HashMap<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = "";
            String a = "";
            for (int j=0;j<2;j++) {
                if (j==0) {
                    s = st.nextToken();
                } else {
                    a = st.nextToken();
                }
            }
            lst.put(s,a);
            if (a.equals("leave")) {
                lst.remove(s);
            }
        }
        ArrayList<String> l = new ArrayList<>(lst.keySet());
        Collections.sort(l, Collections.reverseOrder());

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

    }
}