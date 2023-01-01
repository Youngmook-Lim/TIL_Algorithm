import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int jCash, jNo, sCash, sNo;
    static int cnt;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        jCash = sCash = n;

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 14; i++) {
            int price = arr[i];

            int jBuyNo = jCash / price;
            jCash -= jBuyNo * price;
            jNo += jBuyNo;

            if (i != 0 && arr[i] > arr[i - 1]) {
                if (cnt < 0) {
                    cnt = 1;
                } else {
                    cnt++;
                    if (cnt >= 3) {
                        sCash += sNo * price;
                        sNo = 0;

                    }
                }
            } else if (i != 0 && arr[i] < arr[i - 1]) {
                if (cnt > 0) {
                    cnt = -1;
                } else {
                    cnt--;
                    if (cnt <= -3) {

                        int sBuyNo = sCash / price;
                        sCash -= sBuyNo * price;
                        sNo += sBuyNo;
                    }
                }
            }
        }

        int jTotal = jCash + arr[13] * jNo;
        int sTotal = sCash + arr[13] * sNo;
        
        if (jTotal > sTotal) {
            System.out.println("BNP");
        } else if (jTotal < sTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

        br.close();
    }

    static void buy(int price, int cash, int no) {
        int buyNo = cash / price;
        cash -= buyNo * price;
        no += buyNo;
    }

    static void sell(int price, int cash, int no) {
        cash += no * price;
        no = 0;
    }


}

