import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int size = A.length;
        
        Integer[] a = new Integer[size];
        Integer[] b = new Integer[size];
        for(int i = 0; i < size; i++){
            a[i] = A[i];
            b[i] = B[i];
        }
        
        Arrays.sort(a);
        Arrays.sort(b, (x, y) -> y - x);
        for(int i = 0; i < size; i++){
            answer += a[i] * b[i];
        }

        return answer;
    }
}