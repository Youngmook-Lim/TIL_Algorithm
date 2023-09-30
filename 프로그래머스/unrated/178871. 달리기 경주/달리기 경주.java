import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    
    public String[] solution(String[] players, String[] callings) {
        
        map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            swap(call, players, map);
        }
        
        return players;
    }
    
    public void swap(String call, String[] players, Map<String, Integer> map) {
        // Find position
        int idx = map.get(call);
        
        // Surpassed player
        String next = players[idx - 1];
        
        // Swap in array
        players[idx - 1] = players[idx];
        players[idx] = next;
        
        // Swap in map
        map.put(call, idx - 1);
        map.put(next, idx);
    }
}