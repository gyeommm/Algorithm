import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            
            if("all".equals(s)){
                set.clear();
                for(int i = 1; i <= 20; i++){
                    set.add(i);
                }
            }else if("empty".equals(s)){
                set.clear();
            }else{
                int n = Integer.parseInt(st.nextToken());
                
                if("add".equals(s)){
                    set.add(n);
                }else if("remove".equals(s)){
                    set.remove(n);
                }else if("check".equals(s)){
                    sb.append(set.contains(n) ? 1 : 0).append("\n");
                }else if("toggle".equals(s)){
                    if(!set.add(n)){
                        set.remove(n);
                    }
                }
            }
        }
        
        System.out.print(sb);
    }
}