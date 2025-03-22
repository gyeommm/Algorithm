#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int t;
	cin >> t;
	while(t--){
		int a, b;
		cin >> a >> b;

		queue<pair<int, string>> q;
		q.push({a, ""});
		bool visited[10000] = {false};
		visited[a] = true;

		while(!q.empty()){
			auto [n, s] = q.front();
			q.pop();

			if(n == b){
				cout << s << '\n';
				break;
			}
			
			int D = (n * 2) % 10000;
			int S = n - 1 == -1 ? 9999 : n - 1;
			int L = (n % 1000) * 10 + n / 1000;
			int R = (n % 10) * 1000 + n / 10;

			if(!visited[D]){
				q.push({D, s + "D"});
				visited[D] = true;
			}
			if(!visited[S]){
				q.push({S, s + "S"});
				visited[S] = true;
			}
			if(!visited[L]){
				q.push({L, s + "L"});
				visited[L] = true;
			}
			if(!visited[R]){
				q.push({R, s + "R"});
				visited[R] = true;
			}
		}
	}

    return 0;
}