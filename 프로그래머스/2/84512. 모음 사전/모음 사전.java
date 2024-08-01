class Solution {
    static int answer = 0;
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static String w;

    public static boolean f(String now) {
        if(w.equals(now))
            return true;

        if(now.length() == 5)
            return false;

        for(int i = 0; i < 5; i++){
            StringBuilder next = new StringBuilder(now);
            next.append(alpha[i]);
            answer++;
            if(f(String.valueOf(next)))
                return true;
        }
        
        return false;
    }

    public static int solution(String word) {
        w = word;
        f("");
        return answer;
    }
}