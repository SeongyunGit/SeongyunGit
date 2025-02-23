import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Student> lst = new ArrayList<>();
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name, kor, eng, math);
            lst.add(student);
        }
        Collections.sort(lst, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.kor == o2.kor) {
                    if (o1.eng == o2.eng) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        } return o2.math - o1.math;
                    } return o1.eng - o2.eng;
                } return o2.kor - o1.kor;
            }
        });
        for (Student student : lst) {
            System.out.println(student.name);
        }
    }
}
class Student{
    String name;
    int kor;
    int eng;
    int math;
    Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}