import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int n, k;
    static Country[] countries;

    static class Country implements Comparable<Country> {
        int id, gold, silver, bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            }
            if (this.silver != o.silver) {
                return o.silver - this.silver;
            }
            return o.bronze - this.bronze;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        countries = new Country[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            countries[i] = new Country(id, gold, silver, bronze);
        }

        Arrays.sort(countries);

        int rank = 1;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            Country c = countries[i];
            Country prev = countries[i - 1];
            if (c.gold != prev.gold || c.silver != prev.silver || c.bronze != prev.bronze) {
                rank += cnt;
                cnt = 1;
            } else {
                cnt++;
            }
            if (c.id == k) break;
        }

        System.out.println(rank);
        
        br.close();
    }


}

