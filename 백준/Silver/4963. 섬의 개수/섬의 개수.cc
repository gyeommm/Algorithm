#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);

	int d[8][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	while(true){
		int w, h;
		cin >> w >> h;
		if(w == 0 && h == 0)
			break;
		
		vector<vector<int>> v(h, vector<int>(w));
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++)
				cin >> v[i][j];
		}

		queue<pair<int, int>> q;
		int count = 0;
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(v[i][j] == 1){
					count++;
					v[i][j] = 2;
					q.push({i, j});

					while(!q.empty()){
						int r = q.front().first;
						int c = q.front().second;
						q.pop();

						for(int k = 0; k < 8; k++){
							int nr = r + d[k][0];
							int nc = c + d[k][1];

							if(nr >= 0 && nr < h && nc >= 0 && nc < w && v[nr][nc] == 1){
								v[nr][nc] = 2;
								q.push({nr, nc});
							}
						}
					}
				}
			}
		}

		cout << count << '\n';
	}

	return 0;
}