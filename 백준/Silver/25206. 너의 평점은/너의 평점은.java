import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static class P {
        double totalPoints, totalGPA;

        public P(double totalPoints, double totalGPA) {
            this.totalPoints = totalPoints;
            this.totalGPA = totalGPA;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, P> map = new HashMap<>();
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double points = Double.parseDouble(st.nextToken());
            String gradeChar = st.nextToken();

            if (gradeChar.equals("P")) continue;

            double grade = gradeMap.get(gradeChar);
            double gpa = points * grade;


            if (map.containsKey(name)) {
                P p = map.get(name);
                p.totalGPA += gpa;
                p.totalPoints += points;
            } else {
                map.put(name, new P(points, gpa));
            }
        }

        double totalGPA = 0;
        double totalPoints = 0;
        for (String name : map.keySet()) {
            totalGPA += map.get(name).totalGPA;
            totalPoints += map.get(name).totalPoints;
        }

        System.out.println(totalGPA / totalPoints);

        br.close();
    }


}


