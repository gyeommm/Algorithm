import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j + i <= s.length(); j++){
                set.add(s.substring(j, j + i));
            }
        }
        
        System.out.print(set.size());
    }
}