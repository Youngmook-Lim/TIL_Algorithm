import java.util.*;

class Solution {
    public String solution(String id) {

        // 1
        id = id.toLowerCase();

        // 2
        id = id.replaceAll("[^a-z0-9._-]", "");
        System.out.println(id);
            
        // 3
        id = id.replaceAll("[.]{2,}", ".");
        System.out.println(id);
        
        // 4
        id = id.replaceAll("^[.]|[.]$", "");
        System.out.println(id);
        
        // 5
        if (id.equals("")) {
            id = "a";
        }
        System.out.println(id);
        
        // 6
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            id = id.replaceAll("[.]$", "");
        }
        System.out.println(id);
        
        // 7

        if (id.length() <= 2) {
            while(id.length() <= 2) {
                id += id.charAt(id.length() - 1);
            }
        }
        System.out.println(id);
        
        return id;
    }
}