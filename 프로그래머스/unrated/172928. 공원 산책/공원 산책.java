import java.util.*;

class Solution {
    
    int x, y, h, w;
    Map<String, int[]> directionMap;
    
    public int[] solution(String[] park, String[] routes) {
        
        // Set h, w
        h = park.length;
        w = park[0].length();
        
        // Init map
        directionMap = new HashMap<>();
        directionMap.put("N", new int[] {-1, 0});
        directionMap.put("S", new int[] {1, 0});
        directionMap.put("E", new int[] {0, 1});
        directionMap.put("W", new int[] {0, -1});
        
        // Find S
        loop:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = j;
                    y = i;
                    break loop;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            move(park, routes[i]);
        }
        
        int[] answer = {y, x};
        return answer;
    }
    
    public void move(String[] park, String route) {
        String[] input = route.split(" ");
        int magnitude = Integer.parseInt(input[1]);
        
        // Check if within map
        int[] direction = directionMap.get(input[0]);
        int nx = x + direction[1] * magnitude;
        int ny = y + direction[0] * magnitude;
        
        if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
            return;
        }
        
        // Check if valid path
        for (int i = 1; i <= magnitude; i++) {
            if (park[y + direction[0] * i].charAt(x + direction[1] * i) == 'X') {
                return;
            }
        }
        
        // Set new x, y
        x = nx;
        y = ny; 
    }
}