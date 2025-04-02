#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m;
    cin >> n >> m;
    char temp;
    vector<vector<int>> v(n + 2, vector<int>(m + 2, -1));
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cin >> temp;
            v[i][j] = temp - '0';
        }
    }

    queue<tuple<int, int, bool, int>> q;
    q.push({1, 1, true, 1});
    v[1][1] = 2;
    pair<int, int> d[4] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    while(!q.empty()){
        int r = get<0>(q.front());
        int c = get<1>(q.front());
        bool check = get<2>(q.front());
        int count = get<3>(q.front());

        if(r == n && c == m){
            cout << count;
            return 0;
        }
        /*
        0 : 벽 X, 일반방문 X, 벽뚫방문 X
        1 : 벽 O, 일반방문 X, 벽뚫방문 X
        2 : 벽 X, 일반방문 O, 벽뚫방문 X
        3 : 벽 O, 일반방문 O, 벽뚫방문 X

        4 : 벽 X, 일반방문 X, 벽뚫방문 O
        5 : 벽 O, 일반방문 X, 벽뚫방문 O
        6 : 벽 X, 일반방문 O, 벽뚫방문 O
        7 : 벽 O, 일반방문 O, 벽뚫방문 O
        */
        for(int i = 0; i < 4; i++){
            if(check == true){      // 벽을 부순 적 X
                if(v[r + d[i].first][c + d[i].second] == 0){
                    q.push({r + d[i].first, c + d[i].second, true, count + 1});
                    v[r + d[i].first][c + d[i].second] = 2;
                }
                else if(v[r + d[i].first][c + d[i].second] == 1){
                    q.push({r + d[i].first, c + d[i].second, false, count + 1});
                    v[r + d[i].first][c + d[i].second] = 3;
                }
                else if(v[r + d[i].first][c + d[i].second] == 2){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 3){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 4){
                    q.push({r + d[i].first, c + d[i].second, true, count + 1});
                    v[r + d[i].first][c + d[i].second] = 3;
                }
                else if(v[r + d[i].first][c + d[i].second] == 5){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 6){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 7){
                    continue;
                }
            }
            /*
            0 : 벽 X, 일반방문 X, 벽뚫방문 X
            1 : 벽 O, 일반방문 X, 벽뚫방문 X
            2 : 벽 X, 일반방문 O, 벽뚫방문 X
            3 : 벽 O, 일반방문 O, 벽뚫방문 X

            4 : 벽 X, 일반방문 X, 벽뚫방문 O
            5 : 벽 O, 일반방문 X, 벽뚫방문 O
            6 : 벽 X, 일반방문 O, 벽뚫방문 O
            7 : 벽 O, 일반방문 O, 벽뚫방문 O
            */
            else{                   // 벽을 부순 적 O
                if(v[r + d[i].first][c + d[i].second] == 0){
                    q.push({r + d[i].first, c + d[i].second, false, count + 1});
                    v[r + d[i].first][c + d[i].second] = 4;
                }
                else if(v[r + d[i].first][c + d[i].second] == 1){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 2){
                    q.push({r + d[i].first, c + d[i].second, false, count + 1});
                    v[r + d[i].first][c + d[i].second] = 6;
                }
                else if(v[r + d[i].first][c + d[i].second] == 3){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 4){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 5){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 6){
                    continue;
                }
                else if(v[r + d[i].first][c + d[i].second] == 7){
                    continue;
                }
            }

            // if(v[r + d[i].first][c + d[i].second] == 0){    // 방문한 적이 없는 곳
            //     if(check == false)  // 벽을 부순 적이 있음
            //         v[r + d[i].first][c + d[i].second] = 3;
            //     else                // 벽을 부순 적이 없음
            //         v[r + d[i].first][c + d[i].second] = 2;

            //     q.push({r + d[i].first, c + d[i].second, check, count + 1});
            // }
            // // 벽을 부순 적이 없고, 벽으로 이동
            // else if(check == true && v[r + d[i].first][c + d[i].second] == 1)
            //     q.push({r + d[i].first, c + d[i].second, false, count + 1});
            // // 벽을 부순 적이 없고, 벽이 아닌 곳으로 이동
            // else if(check == true && v[r + d[i].first][c + d[i].second] == 3)
            //     q.push({r + d[i].first, c + d[i].second, check, count + 1});
        }
        q.pop();
    }
    cout << -1;
	return 0;
}