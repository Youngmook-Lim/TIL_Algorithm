class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 0; i < arrayA.length; i++) {
            gcdA = getGcd(gcdA, arrayA[i]);
        }
        
        for (int i = 0; i < arrayB.length; i++) {
            gcdB = getGcd(gcdB, arrayB[i]);
        }
        
        if (gcdA == gcdB) {
            return 0;
        } else if (gcdA > gcdB) {
            return check(arrayA, arrayB, gcdA, gcdB);
        } else {
            return check(arrayB, arrayA, gcdB, gcdA);
        }
        
    }
    
    public int check(int[] arrA, int[] arrB, int a, int b) {
        boolean flag = true;
        for (int i = 0; i < arrB.length; i++) {
            if (arrB[i] % a == 0) {
                flag = false;
                break;
            }
        }
        if (flag) return a;
        
        flag = true;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] % b == 0) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            return b;
        } else {
            return 0;
        }
        
    }
    
    public int getGcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return getGcd(b % a, a);
    }
}