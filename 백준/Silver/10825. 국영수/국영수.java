import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int korean, english, math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean != o.korean) {
                return o.korean - this.korean;
            }
            if (this.english != o.english) {
                return this.english - o.english;
            }
            if (this.math != o.math) {
                return o.math - this.math;
            }
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name, korean, english, math);
            arr[i] = student;
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i].name).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

}














