import java.util.*;

class Solution {    
    public int[] solution(String[] info, String[] query) {
        String[][] option = {{"cpp", "java", "python"}, {}, {"backend", "frontend"}, {}, {"junior", "senior"}, {}, {"chicken", "pizza"}};

        int[] answer = new int[query.length];

        Map<String, List<Integer>> m = new HashMap<>();

        for(int i = 0; i < info.length; i++){
            StringBuilder sb = new StringBuilder();
            String[] temp = info[i].split(" ");

            for(int j = 0; j < temp.length - 1; j++){
                sb.append(temp[j]);
            }

            List<Integer> list = m.get(sb.toString());
            if(list == null){
                list = new ArrayList<>();
                m.put(sb.toString(), list);
            }

            list.add(Integer.parseInt(temp[temp.length - 1]));
        }

        for(Map.Entry<String, List<Integer>> entry : m.entrySet()){
            List<Integer> list = entry.getValue();
            Collections.sort(list);
        }

        for(int i = 0; i < query.length; i++){
            String[] temp = query[i].split(" ");

            Queue<StringBuilder> q = new ArrayDeque<>();
            q.offer(new StringBuilder());

            for(int j = 0; j < temp.length - 1; j += 2){
                int size = q.size();
                while(size-- > 0){
                    if(temp[j].equals("-")){
                        for(int l = 0; l < option[j].length; l++){
                            StringBuilder copy = new StringBuilder(q.peek());
                            copy.append(option[j][l]);
                            q.offer(copy);
                        }
                    }else{
                        StringBuilder copy = new StringBuilder(q.peek());
                        copy.append(temp[j]);
                        q.offer(copy);
                    }

                    q.poll();
                }
            }

            while(!q.isEmpty()){
                StringBuilder key = q.poll();

                List<Integer> list = m.get(key.toString());
                if(list == null){
                    continue;
                }

                int score = Integer.parseInt(temp[temp.length - 1]);
                int index = Collections.binarySearch(list, score);

                if(index < 0){
                    index = -(index + 1);
                }else{
                    for(int j = index - 1; j >= 0; j--){
                        if(list.get(j) < score){
                            break;
                        }

                        index--;
                    }
                }

                answer[i] += list.size() - index;
            }
        }

        return answer;
    }
}