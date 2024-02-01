import java.util.*;

class Solution {
    
    class P {
        String status, uid;
        P(String status, String uid) {
            this.status = status;
            this.uid = uid;
        }
    }
    
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        List<P> list = new ArrayList<>();
        
        for (String x : record) {
            String[] cmd = x.split(" ");
            
            if (cmd[0].equals("Enter")) {
                list.add(new P("Enter", cmd[1]));
                map.put(cmd[1], cmd[2]);
            } else if (cmd[0].equals("Leave")) {
                list.add(new P("Leave", cmd[1]));
            } else {
                map.put(cmd[1], cmd[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(list.get(i).uid)).append("님이 ");
            sb.append(list.get(i).status.equals("Enter") ? "들어왔" : "나갔");
            sb.append("습니다.");
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}