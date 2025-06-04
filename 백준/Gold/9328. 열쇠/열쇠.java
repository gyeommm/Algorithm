import java.util.*;
import java.io.*;

class Main{
    static class Node{
        int r;
        int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            char[][] map = new char[r + 2][c + 2];
            for(int i = 0; i < r + 2; i++){
                for(int j = 0; j < c + 2; j++){
                    map[i][j] = '.';
                }
            }
            for(int i = 1; i <= r; i++){
                String s = br.readLine();
                for(int j = 1; j <= c; j++){
                    map[i][j] = s.charAt(j - 1);
                }
            }

            Set<Character> keys = new HashSet<>();
            String s = br.readLine();
            for(int i = 0; i < s.length(); i++){
                keys.add(Character.toUpperCase(s.charAt(i)));
            }

            Queue<Node> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[r + 2][c + 2];
            q.offer(new Node(0, 0));
            visited[0][0] = true;

            Map<Character, List<Node>> doors = new HashMap<>();
            while(!q.isEmpty()){
                Node now = q.poll();

                if(map[now.r][now.c] == '$'){
                    result++;
                }else if(Character.isLowerCase(map[now.r][now.c])){     // 열쇠
                    char door = Character.toUpperCase(map[now.r][now.c]);
                    keys.add(door);

                    if(doors.containsKey(door)){        // 열쇠가 없어 못 열었던 문이 있음
                        for(Node node : doors.get(door)){
                            q.offer(node);
                        }
                        doors.remove(door);
                    }
                }else if(Character.isUpperCase(map[now.r][now.c])){     // 문
                    if(!keys.contains(map[now.r][now.c])){      // 열쇠가 없는 경우
                        List<Node> list = doors.getOrDefault(map[now.r][now.c], new ArrayList<>());
                        list.add(now);
                        doors.put(map[now.r][now.c], list);
                        continue;
                    }
                }

                for(int i = 0; i < 4; i++){
                    Node next = new Node(now.r + d[i][0], now.c + d[i][1]);

                    if(next.r < 0 || next.r > r + 1 || next.c < 0 || next.c > c + 1 || visited[next.r][next.c] || map[next.r][next.c] == '*'){
                        continue;
                    }

                    q.offer(next);
                    visited[next.r][next.c] = true;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}