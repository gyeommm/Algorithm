#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;

	vector<pair<int, int>> vp;
	for (int i = 0; i < n; i++) {
		pair<int, int> temp;
		cin >> temp.first >> temp.second;
		vp.push_back(temp);
	}

	sort(vp.begin(), vp.end());

	int i = 0, count = 1;
	for (int j = i + 1; j < n; j++) {
		if (vp[j].second < vp[i].second)
			i = j;
		else if (vp[j].first >= vp[i].second) {
			i = j;
			count++;
		}
	}
	
	cout << count << "\n";

	return 0;
}