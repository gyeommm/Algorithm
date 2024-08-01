class Solution {
    static int answer = 0;
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static StringBuilder s = new StringBuilder();

    public static boolean f(int k, String word) {
        s.append(alpha[k]);
        answer++;

        if (word.contentEquals(s))
            return true;
        return false;
    }

    public static int solution(String word) {
        for(int a = 0; a < 5; a++){
            if(f(a, word))
                return answer;
            for(int b = 0; b < 5; b++){
                if(f(b, word))
                    return answer;
                for(int c = 0; c < 5; c++){
                    if(f(c, word))
                        return answer;
                    for(int d = 0; d < 5; d++){
                        if(f(d, word))
                            return answer;
                        for(int e = 0; e < 5; e++){
                            if(f(e, word))
                                return answer;
                            s = new StringBuilder(s.substring(0, s.length() - 1));
                        }
                        s = new StringBuilder(s.substring(0, s.length() - 1));
                    }
                    s = new StringBuilder(s.substring(0, s.length() - 1));
                }
                s = new StringBuilder(s.substring(0, s.length() - 1));
            }
            s = new StringBuilder(s.substring(0, s.length() - 1));
        }

        return -1;
    }
}