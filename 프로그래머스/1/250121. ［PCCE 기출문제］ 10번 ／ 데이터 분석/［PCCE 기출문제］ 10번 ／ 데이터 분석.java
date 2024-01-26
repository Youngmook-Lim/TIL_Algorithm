import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        String[] type = {"code", "date", "maximum", "remain"};
        List<String> typeList = Arrays.asList(type);
        
        int filterIdx = typeList.indexOf(ext);
        int sortIdx = typeList.indexOf(sort_by);
        
        return Arrays.stream(data).filter(d -> d[filterIdx] < val_ext).sorted((o1, o2) -> o1[sortIdx] - o2[sortIdx]).toArray(int[][]::new);
        
    }
}