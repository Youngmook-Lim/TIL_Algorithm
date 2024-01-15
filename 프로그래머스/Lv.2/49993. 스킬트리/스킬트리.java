import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }
        
        int idx = 0;
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String tree = skill_trees[i];
            boolean flag = true;
            idx = 0;
            // System.out.println();
            for (int j = 0; j < tree.length() && idx < skill.length(); j++) {
                char curChar = tree.charAt(j);
                // System.out.println("skill : " + skill.charAt(idx) + " / cur : " + curChar);
                if (set.contains(curChar) && skill.charAt(idx) != curChar) {
                    flag = false;
                    break;
                }
                if (skill.charAt(idx) == curChar) {
                    idx++;
                }
            }
            if (flag) {
                answer++;
            }
            
        }
        
        return answer;
    }
}