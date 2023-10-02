import java.util.*;

class Solution {
    
    Map<Character, Integer> termsMap;
    int year, month, day;
    List<Integer> answerList;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // Init termsMap
        termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0].charAt(0), Integer.parseInt(term[1]));
        }
        
        // Init today
        String[] todayArr = today.split("\\.");
        year = Integer.parseInt(todayArr[0]);
        month = Integer.parseInt(todayArr[1]);
        day = Integer.parseInt(todayArr[2]);
        
        // Init answerList
        answerList = new ArrayList<>();
        
        // Solve
        for (int i = 0; i < privacies.length; i++) {
            String[] dateArr = privacies[i].split(" ")[0].split("\\.");
            int collectYear = Integer.parseInt(dateArr[0]);
            int collectMonth = Integer.parseInt(dateArr[1]);
            int collectDay = Integer.parseInt(dateArr[2]);
            
            char type = privacies[i].split(" ")[1].charAt(0);
            
            // Get add month
            int addMonth = termsMap.get(type);
            
            int newMonth = collectMonth + addMonth;
            
            collectYear += (newMonth - 1) / 12;
            collectMonth = newMonth % 12 == 0 ? 12 : newMonth % 12;
            
            // Check
            if (year > collectYear) {
                answerList.add(i + 1);
            } else if (year == collectYear) {
                if (month > collectMonth) {
                    answerList.add(i + 1);
                } else if (month == collectMonth) {
                    if (day >= collectDay) {
                        answerList.add(i + 1);
                    }
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}