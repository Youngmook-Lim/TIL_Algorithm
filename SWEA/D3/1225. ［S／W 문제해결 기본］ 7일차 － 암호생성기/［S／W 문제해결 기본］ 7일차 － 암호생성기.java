import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    static class LinkedQueue {
        Node front;
        Node rear;
        int size;

        void enQueue(int data) {
            Node node = new Node(data);
            if (size == 0) {
                front = node;
                rear = node;
            } else {
                rear.link = node;
                rear = node;
            }
            size++;
        }

        int deQueue() {
            if (front == null) {
                return -1;
            }
            int tmp = front.data;
            front = front.link;
            size--;
            if (front == null) {
                rear = null;
            }
            return tmp;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void printQueue() {
            Node cur = front;
            if (front == null) {
                System.out.println("Empty Queue");
            }
            while (cur != null) {
                System.out.print(cur.data + "-");
                cur = cur.link;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            int _ = Integer.parseInt(br.readLine());

            LinkedQueue q = new LinkedQueue();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 8; i++) {
                int x = Integer.parseInt(st.nextToken());
                q.enQueue(x);
                if (x < min) {
                    min = x;
                }
            }

            int a = (min % 15 == 0) ? min / 15 - 1 : min / 15;
            for (int i = 0; i < 8; i++) {
                q.enQueue(q.deQueue() - 15 * a);
            }

            int counter = 1;

            while (true) {
                if (counter > 5) {
                    counter = 1;
                }
                int tmp = q.deQueue();
                tmp -= counter;
                if (tmp <= 0) {
                    q.enQueue(0);
                    break;
                } else {
                    q.enQueue(tmp);
                }
                counter++;
            }

            bw.write("#" + t + " ");
            while (!q.isEmpty()) {
                bw.write(q.deQueue() + " ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}