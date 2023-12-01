import java.util.*;

class Solution {
    
    public class Op {
        char cmd;
        int n;
        
        public Op(char cmd, int n) {
            this.cmd = cmd;
            this.n = n;
        }
    }
    
    public int[] solution(String[] operations) {
        
        TreeSet<Integer> tSet = new TreeSet<>(); 
        
        for (String x : operations) {
            Op op = getOp(x);
            if (op.cmd == 'I') {
                tSet.add(op.n);
            } else {
                if (op.n == 1) {
                    tSet.pollLast();
                } else {
                    tSet.pollFirst();
                }
            }
        }
        
        if (tSet.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {tSet.last(), tSet.first()};
        }
        
    }
    
    public Op getOp(String x) {
        String[] tmp = x.split(" ");
        return new Op(tmp[0].charAt(0), Integer.parseInt(tmp[1]));
    }
}