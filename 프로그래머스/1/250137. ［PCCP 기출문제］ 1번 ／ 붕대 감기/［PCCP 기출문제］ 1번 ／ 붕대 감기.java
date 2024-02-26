import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int remainingHealth = health;
        
        int cnt = 0;
        int finalTime = attacks[attacks.length - 1][0];
        int[] isAttack = new int[finalTime + 1];
        for (int i = 0; i < attacks.length; i++) {
            isAttack[attacks[i][0]] = attacks[i][1];
        }
        
        for (int i = 1; i <= finalTime; i++) {
            if (isAttack[i] > 0) {
                remainingHealth -= isAttack[i];
                cnt = 0;
                if (remainingHealth <= 0) {
                    return -1;
                }
            } else {
                remainingHealth = Math.min(health, remainingHealth + x);
                cnt++;
                if (cnt == t) {
                    remainingHealth = Math.min(health, remainingHealth + y);
                    cnt = 0;
                }
            }
        }
        
        return remainingHealth;
    }
}