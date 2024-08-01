class Solution {
    static int count = 0, answer = 0;
    static boolean check = false;
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static StringBuilder s = new StringBuilder();
    static String w;

    public static void f(StringBuilder now) {
        if(w.equals(String.valueOf(now))){
            answer = count;
            check = true;
            return;
        }

        if(check || now.length() == 5)
            return;

        for(int i = 0; i < 5; i++){
            StringBuilder next = new StringBuilder(now);
            next.append(alpha[i]);
            count++;
            f(next);
        }
    }

    public static int solution(String word) {
        w = word;
        f(new StringBuilder(""));
        return answer;
    }
}