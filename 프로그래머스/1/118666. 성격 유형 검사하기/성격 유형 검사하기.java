import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> scores = new HashMap<>();
        scores.put('R', 0);
        scores.put('T', 0);
        scores.put('F', 0);
        scores.put('C', 0);
        scores.put('M', 0);
        scores.put('J', 0);
        scores.put('A', 0);
        scores.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            String el = survey[i];
            
            if (choices[i] < 4) {
                scores.put(el.charAt(0), 
                           scores.get(el.charAt(0)) + (4 - choices[i]));
            } else if (choices[i] > 4) {
                scores.put(el.charAt(1), 
                           scores.get(el.charAt(1)) + choices[i] - 4);
            }
        }
        
        System.out.println(scores);
        
        StringBuilder sb = new StringBuilder();
        if (scores.get('T') > scores.get('R')) {
            sb.append('T');
        } else if (scores.get('T') <= scores.get('R')) {
            sb.append('R');
        }
        if (scores.get('F') > scores.get('C')) {
            sb.append('F');
        } else if (scores.get('F') <= scores.get('C')) {
            sb.append('C');
        }
        if (scores.get('M') > scores.get('J')) {
            sb.append('M');
        } else if (scores.get('M') <= scores.get('J')) {
            sb.append('J');
        }
        if (scores.get('N') > scores.get('A')) {
            sb.append('N');
        } else if (scores.get('N') <= scores.get('A')) {
            sb.append('A');
        }
        
        return sb.toString();
    }
}