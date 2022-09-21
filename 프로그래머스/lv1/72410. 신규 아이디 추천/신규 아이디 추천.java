import java.util.*;

class Solution {
    public String solution(String id) {
        // System.out.println((int) 'a');
        
        
        // 1
        id = id.toLowerCase();
        // System.out.println(id);
        // 2
        StringBuilder sb = new StringBuilder();
        char[] idc = id.toCharArray();
        for (int i = 0; i < idc.length; i++) {
            if ((idc[i] >= 97 && idc[i] <= 122) || (idc[i] >= 48 && idc[i] <= 57) || 
               idc[i] == '-' || idc[i] == '_' || idc[i] == '.') {
                sb.append(idc[i]);
            }
        }
        // System.out.println(sb.toString());
        // 3
        String tmp = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '.') {
                while (i < tmp.length() && tmp.charAt(i) == '.') {
                    i++;
                }
                sb.append('.');
                i--;                
            } else {
                sb.append(tmp.charAt(i));
            }
        }
        // System.out.println(sb.toString());
        // 4
        tmp = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            if (i == 0 || i == tmp.length() - 1) {
                if (tmp.charAt(i) == '.') {
                    continue;
                } else {
                    sb.append(tmp.charAt(i));
                }         
            } else {
                sb.append(tmp.charAt(i));
            }
        }
        // System.out.println(sb.toString());
        // 5
        tmp = sb.toString();
        if (tmp.equals("")) {
            tmp += "a";
        }
        System.out.println(tmp);
        // 6
        sb = new StringBuilder();
        if (tmp.length() >= 16) {
            tmp = tmp.substring(0, 15);
            int idx = tmp.length() - 1;
            while (tmp.charAt(idx) == '.') {
                idx--;
            }
            for (int i = 0; i <= idx; i++) {
                sb.append(tmp.charAt(i));
            }
        } else {
            sb.append(tmp);
        }
        System.out.println(sb.toString());
        // 7
        tmp = sb.toString();
        char last = tmp.charAt(tmp.length()-1);
        if (tmp.length() <= 2) {
            while(tmp.length() <= 2) {
                tmp += last;
            }
        }
        
        return tmp;
    }
}