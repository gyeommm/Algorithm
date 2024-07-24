#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n, m, x, y, k;
	cin >> n >> m >> x >> y >> k;
	vector<vector<int>> v(n, vector<int>(m));
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++)
			cin >> v[i][j];
	}

	int dice[6] = {0};	// 위 서 동 남 북 아래
	int d[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	while(k--){
		int move, nx, ny;
		cin >> move;

		nx = x + d[move - 1][0];
		ny = y + d[move - 1][1];

		if(nx < 0 || nx >= n || ny < 0 || ny >= m)
			continue;

		x = nx;
		y = ny;
		if(move == 1){
			swap(dice[0], dice[1]);
			swap(dice[1], dice[5]);
			swap(dice[2], dice[5]);
		}
		else if(move == 2){
			swap(dice[0], dice[2]);
			swap(dice[1], dice[2]);
			swap(dice[2], dice[5]);
		}
		else if(move == 3){
			swap(dice[0], dice[3]);
			swap(dice[3], dice[5]);
			swap(dice[4], dice[5]);
		}
		else if(move == 4){
			swap(dice[0], dice[4]);
			swap(dice[3], dice[4]);
			swap(dice[4], dice[5]);
		}

		if(v[x][y] == 0)
			v[x][y] = dice[5];
		else{
			dice[5] = v[x][y];
			v[x][y] = 0;
		}

		cout << dice[0] << '\n';
	}

	return 0;
}