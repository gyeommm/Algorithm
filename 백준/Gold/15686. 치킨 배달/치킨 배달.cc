#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int result = 10000;
vector<pair<int, int>> chicken;

void f(vector<set<pair<int, int>>> dist, vector<int> pick){
    do{
        int compare = 0;
        for(int i = 0; i < dist.size(); i++){
            for(pair<int, int> entry : dist[i]){
                if(pick[entry.second] == 1){
                    compare += entry.first;
                    break;
                }
            }
        }
        result = min(result, compare);
    }
    while(next_permutation(pick.begin(), pick.end()));
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

    int n, m, temp;
    cin >> n >> m;
    vector<pair<int, int>> house;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> temp;
            if(temp == 1)
                house.push_back({i, j});
            else if(temp == 2)
                chicken.push_back({i, j});
        }
    }

    vector<int> pick(chicken.size(), 1);
    for(int i = 0; i < chicken.size() - m; i++)
        pick[i] = 0;

    vector<set<pair<int, int>>> dist(house.size());
    for(int i = 0; i < house.size(); i++){
        for(int j = 0; j < chicken.size(); j++)
            dist[i].insert({abs(house[i].first - chicken[j].first) + abs(house[i].second - chicken[j].second), j});
    }

    f(dist, pick);
    cout << result;

	return 0;
}