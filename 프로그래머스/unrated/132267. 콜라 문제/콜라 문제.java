class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        int leftoverBottles = 0;
        
        while (n > 0) {
            int additionalCoke = n / a * b;
            int remainingBottles = n % a;
            
            remainingBottles += leftoverBottles;
            if (remainingBottles >= a) {
                additionalCoke += b;
                
                remainingBottles -= a;
            }
            
            leftoverBottles = remainingBottles;           
            
            n = additionalCoke;
            
            answer += additionalCoke;
        }

        return answer;
    }
}