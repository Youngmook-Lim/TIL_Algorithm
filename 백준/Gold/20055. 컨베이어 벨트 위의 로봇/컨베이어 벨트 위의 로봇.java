import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 1. 큐 2개를 사용해서 active, inactive 벨트를 구현한다.
 * 2. 각 칸은 클래스로 내구도와 로봇이 있는지 없는지 값을 구현한다.
 * */
class Main {

    static int n, k, stage;
    static Deque<Belt> active, inactive;

    static class Belt {
        int hp;
        boolean hasRobot;

        public Belt(int hp, boolean hasRobot) {
            this.hp = hp;
            this.hasRobot = hasRobot;
        }

        @Override
        public String toString() {
            return "[" +
                    hp +
                    " " + hasRobot +
                    ']';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        active = new ArrayDeque<>();
        inactive = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            int hp = Integer.parseInt(st.nextToken());
            if (i < n) {
                active.add(new Belt(hp, false));
            } else {
                inactive.add(new Belt(hp, false));
            }
        }

        simulation();

        System.out.println(stage);

        br.close();
    }

    static void simulation() {
        while (true) {
            stage++;
            rotateBelt();
            moveRobots();
            addRobot();
            if (checkHp()) {
                return;
            }
        }
    }

    static void rotateBelt() {
        inactive.addFirst(active.pollLast());
        active.addFirst(inactive.pollLast());
        if (active.getLast().hasRobot) {
            active.getLast().hasRobot = false;
        }
    }

    static void moveRobots() {
        for (int i = 0; i < n; i++) {
            Belt cur = active.pollLast();
            if (cur.hasRobot && !active.getFirst().hasRobot && active.getFirst().hp > 0) {
                active.getFirst().hasRobot = true;
                active.getFirst().hp--;
                if (active.getFirst().hp == 0) {
                    k--;
                }
                cur.hasRobot = false;
            }
            active.addFirst(cur);
        }
        if (active.getLast().hasRobot) {
            active.getLast().hasRobot = false;
        }
    }

    static void addRobot() {
        if (active.getFirst().hp > 0) {
            active.getFirst().hasRobot = true;
            active.getFirst().hp--;
            if (active.getFirst().hp == 0) {
                k--;
            }
        }
    }

    static boolean checkHp() {
        return k <= 0;
    }

}