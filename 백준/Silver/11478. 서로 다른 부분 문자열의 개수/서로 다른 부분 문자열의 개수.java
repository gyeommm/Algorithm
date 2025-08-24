import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        Set<String> set = new HashSet<>();
        int result = 0;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j + i <= s.length(); j++){
                set.add(s.substring(j, j + i));
            }
            
            result += set.size();
            set.clear();
        }
        
        System.out.print(result);
    }
}