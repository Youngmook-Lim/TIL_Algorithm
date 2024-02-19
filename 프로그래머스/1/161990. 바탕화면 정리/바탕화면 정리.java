import java.util.*;

class Solution {
    
    int minX, minY, maxX, maxY;
    
    public int[] solution(String[] wallpaper) {
        
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char cur = wallpaper[i].charAt(j);
                
                if (cur == '.') continue;
                
                minX = Math.min(minX, j);
                minY = Math.min(minY, i);
                maxX = Math.max(maxX, j);
                maxY = Math.max(maxY, i);
            }
        }
        
        int[] answer = {minY, minX, maxY + 1, maxX + 1};
        
        return answer;
    }
}