import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] arr= new Long[N];
        HashMap<Long, Long> map = new HashMap<>();
        for (int i=0;i<N;i++ ) {
            Long s = Long.parseLong(br.readLine());
            if (map.containsKey(s)) {
                Long a = map.get(s);
                map.put(s, a+1);
            } else {
                map.put(s,1L);
            }
        }
        Long result=0L;
        Long answer = 0L;
        for (Map.Entry<Long, Long> integerIntegerEntry : map.entrySet()) {
            if (result<integerIntegerEntry.getValue()) {
                result = Math.max(result, integerIntegerEntry.getValue());
                answer = integerIntegerEntry.getKey();
            } else if (result.equals(integerIntegerEntry.getValue())) {
                answer = Math.min(answer, integerIntegerEntry.getKey());
            }
        }
        System.out.println(answer);
    }
}