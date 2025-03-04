#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n, m, r, rr;
    cin >> n >> m >> r;
    
    vector<vector<int>> v(n, vector<int>(m));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++)
            cin >> v[i][j];
    }
    
    // 상하반전, 좌우반전, 회전
    bool ud = false;
    bool lr = false;
    int spin = 0;
    deque<int> pos = {0, 1, 2, 3};
    
    while(r--){
        cin >> rr;
        
        if(rr == 1){
            // 0123 -> 3210
            reverse(pos.begin(), pos.end());
        
            if(spin % 2 == 1)
                lr = !lr;
            else
                ud = !ud;
        }
        else if(rr == 2){
            // 0123 -> 1032
            swap(pos[0], pos[1]);
            swap(pos[2], pos[3]);
            
            if(spin % 2 == 1)
                ud = !ud;
            else
                lr = !lr;
        }
        else if(rr == 3){
            // 0123 -> 3012
            pos.push_front(pos.back());
            pos.pop_back();
        
            ++spin %= 4;
        }
        else if(rr == 4){
            // 0123 -> 1230
            pos.push_back(pos.front());
            pos.pop_front();
        
            spin += 3;
            spin %= 4;
        }
        else if(rr == 5){
            // 0123 -> 3012
            pos.push_front(pos.back());
            pos.pop_back();
        }
        else if(rr == 6){
            // 0123 -> 1230
            pos.push_back(pos.front());
            pos.pop_front();
        }
    }

    vector<vector<vector<int>>> mass(4, vector<vector<int>>(n / 2, vector<int>(m / 2)));
    for(int i = 0; i < n / 2; i++){
        for(int j = 0; j < m / 2; j++){
            mass[0][i][j] = v[i][j];
            mass[1][i][j] = v[i][j + m / 2];
            mass[2][i][j] = v[i + n / 2][j + m / 2];
            mass[3][i][j] = v[i + n / 2][j];
        }
    }
    
    if(ud){
        for(int k = 0; k < mass.size(); k++){
            for(int i = 0; i < mass[k].size() / 2; i++)
                swap(mass[k][i], mass[k][mass[k].size() - 1 - i]);
        }
    }
    
    if(lr){
        for(int k = 0; k < mass.size(); k++){
            for(int i = 0; i < mass[k].size(); i++)
                reverse(mass[k][i].begin(), mass[k][i].end());
        }
    }

    while(spin--){
        for(int k = 0; k < mass.size(); k++){
            int row = mass[k][0].size();
            int col = mass[k].size();
            vector<vector<int>> temp(row, vector<int>(col));

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++)
                    temp[i][j] = mass[k][col - 1 - j][i];
            }
            mass[k] = temp;
        }
    }
    
    for(int i = 0; i < mass[pos[0]].size(); i++){
        for(int j = 0; j < mass[pos[0]][0].size(); j++)
            cout << mass[pos[0]][i][j] << ' ';

        for(int j = 0; j < mass[pos[1]][0].size(); j++)
            cout << mass[pos[1]][i][j] << ' ';

        cout << '\n';
    }
    for(int i = 0; i < mass[pos[2]].size(); i++){
        for(int j = 0; j < mass[pos[3]][0].size(); j++)
            cout << mass[pos[3]][i][j] << ' ';

        for(int j = 0; j < mass[pos[2]][0].size(); j++)
            cout << mass[pos[2]][i][j] << ' ';

        cout << '\n';
    }

    return 0;
}