#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int d[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int R, C, T;
    cin >> R >> C >> T;
    
    int air;
    vector<vector<int>> v(R + 2, vector<int>(C + 2, -2));
    vector<vector<int>> temp(R + 2, vector<int>(C + 2));
    for(int i = 1; i <= R; i++){
        for(int j = 1; j <= C; j++){
            cin >> v[i][j];
            
            if(v[i][j] == -1)
                air = i;
        }
    }
    
    while(T--){
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if((i == air || i == air - 1) && j == 1)
                    continue;
                    
                temp[i][j] = 0;
                int count = 0;
                for(int l = 0; l < 4; l++){
                    int r = i + d[l][0];
                    int c = j + d[l][1];
                    
                    if(v[r][c] < 0)
                        continue;
                    
                    count++;
                    temp[i][j] += v[r][c] / 5;
                }
                
                if(v[i][j] > 0)
                    temp[i][j] += v[i][j] - v[i][j] / 5 * count;
            }
        }
        
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if(i == air - 1 && j < C)
                    v[i][j + 1] = temp[i][j];
                else if(i <= air - 1 && i > 1 && j == C)
                    v[i - 1][j] = temp[i][j];
                else if(i == 1 && j > 1)
                    v[i][j - 1] = temp[i][j];
                else if(i < air - 2 && j == 1)
                    v[i + 1][j] = temp[i][j];
                else if(i == air && j < C)
                    v[i][j + 1] = temp[i][j];
                else if(i >= air && i < R && j == C)
                    v[i + 1][j] = temp[i][j];
                else if(i == R && j > 1)
                    v[i][j - 1] = temp[i][j];
                else if(i > air + 1 && j == 1)
                    v[i - 1][j] = temp[i][j];
                else{
                    if(j == 1 && (i == air + 1 || i == air - 2))
                        continue;
                    v[i][j] = temp[i][j];
                }
            }
        }
    }
    
    int result = 0;
    for(int i = 1; i <= R; i++){
        for(int j = 1; j <= C; j++){
            if(v[i][j] > 0)
                result += v[i][j];
        }
    }
    
    cout << result;
    return 0;
}