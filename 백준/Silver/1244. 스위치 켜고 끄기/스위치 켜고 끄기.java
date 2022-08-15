import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] switches;
    static int studentNum;
    static int sex;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        switches = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        studentNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            sex = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());

            switch (sex) {
                case (1):
                    int mult = num;
                    while (mult <= n) {
                        switches[mult - 1] = (switches[mult - 1] == 1) ? 0 : 1;
                        mult += num;
                    }
                    break;
                case (2):
                    int side = 0;
                    while (true) {
                        if (num - 1 - side >= 0 && num - 1 + side < n) {
                            if (switches[num - 1 - side] != switches[num - 1 + side]) {
                                break;
                            } else {
                                if (switches[num - 1 - side] == 0) {
                                    switches[num - 1 - side] = 1;
                                    switches[num - 1 + side] = 1;
                                } else {
                                    switches[num - 1 - side] = 0;
                                    switches[num - 1 + side] = 0;
                                }
                            }
                            side++;
                        } else {
                            break;
                        }
                    }
                    break;
            }
        }

        StringBuilder sb;
        int idx = 0;
        while (idx < n) {
            sb = new StringBuilder();
            if (n - idx > 20) {
                for (int i = idx; i < idx + 20; i++) {
                    sb.append(switches[i]).append(" ");
                }
                bw.write(sb.toString() + "\n");
                idx += 20;
            } else {
                for (int i = idx; i < n; i++) {
                    sb.append(switches[i]).append(" ");
                }
                bw.write(sb.toString() + "\n");
                idx += 20;
            }
        }


        bw.flush();
        bw.close();
        br.close();

    }

}

