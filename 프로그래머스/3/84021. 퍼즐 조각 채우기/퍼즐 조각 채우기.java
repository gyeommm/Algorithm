import java.util.*;

class Solution {
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;

    static class Puzzle{
        int count;
        int[][] puzzle;

        Puzzle(int count, int[][] puzzle){
            this.count = count;
            this.puzzle = puzzle;
        }
    }

    static void dfs(int[][] arr, int[][] visited, int r, int c, List<int[]> pos, int targetNum){
        visited[r][c] = 1;
        pos.add(new int[]{r, c});

        for(int i = 0; i < 4; i++){
            int nr = r + d[i][0];
            int nc = c + d[i][1];

            if(nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc] == 1 || arr[nr][nc] != targetNum){
                continue;
            }

            dfs(arr, visited, nr, nc, pos, targetNum);
        }
    }

    static Queue<Puzzle> getPuzzles(int[][] arr, int targetNum){
        Queue<Puzzle> puzzles = new ArrayDeque<>();

        int[][] visited = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != targetNum || visited[i][j] == 1){
                    continue;
                }

                List<int[]> pos = new ArrayList<>();
                dfs(arr, visited, i, j, pos, targetNum);

                Puzzle puzzle = new Puzzle(pos.size(), getMatrix(pos));
                puzzles.offer(puzzle);
            }
        }

        return puzzles;
    }

    // 리스트에 담긴 좌표를 '좌상단 정렬된 행렬 형태'로 만들어 반환
    static int[][] getMatrix(List<int[]> pos){
        int minR = 50, maxR = 0;
        int minC = 50, maxC = 0;

        for(int[] temp : pos){
            minR = Math.min(minR, temp[0]);
            maxR = Math.max(maxR, temp[0]);
            minC = Math.min(minC, temp[1]);
            maxC = Math.max(maxC, temp[1]);
        }

        int size = Math.max(maxR - minR, maxC - minC) + 1;
        int[][] puzzle = new int[size][size];

        for(int[] temp : pos){
            puzzle[temp[0] - minR][temp[1] - minC] = 1;
        }

        return puzzle;
    }

    static boolean compare(int[][] target, int[][] puzzle){
        int size = target.length;

        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                if(target[r][c] != puzzle[r][c]){
                    return false;
                }
            }
        }

        return true;
    }

    static int[][] getSpin90(int[][] arr){
        int size = arr.length;
        int[][] spinedArr = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                spinedArr[j][size - 1 - i] = arr[i][j];
            }
        }

        // 좌상단에 붙이기
        int minR = size, minC = size;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(spinedArr[i][j] == 1){
                    minR = i;
                    i = size;
                    break;
                }
            }
        }

        for(int j = 0; j < size; j++){
            for(int i = 0; i < size; i++){
                if(spinedArr[i][j] == 1){
                    minC = j;
                    j = size;
                    break;
                }
            }
        }

        int[][] orderedArr = new int[size][size];
        for(int i = minR; i < size; i++){
            for(int j = minC; j < size; j++){
                orderedArr[i - minR][j - minC] = spinedArr[i][j];
            }
        }

        return orderedArr;
    }

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        n = table.length;

        Queue<Puzzle> boardPuzzles = getPuzzles(game_board, 0);
        Queue<Puzzle> tablePuzzles = getPuzzles(table, 1);

        for(Puzzle t1 : boardPuzzles){
            int size = tablePuzzles.size();
            for(int i = 0; i < size; i++){
                Puzzle t2 = tablePuzzles.poll();

                if(t1.count != t2.count || t1.puzzle.length != t2.puzzle.length){
                    tablePuzzles.offer(t2);
                    continue;
                }

                // 90도 회전시키면서 4번 확인
                for(int j = 0; j < 4; j++){
                    if(compare(t1.puzzle, t2.puzzle)){
                        answer += t1.count;
                        i = size;
                        break;
                    }

                    t2.puzzle = getSpin90(t2.puzzle);

                    if(j == 3){
                        tablePuzzles.offer(t2);
                    }
                }
            }
        }

        return answer;
    }
}