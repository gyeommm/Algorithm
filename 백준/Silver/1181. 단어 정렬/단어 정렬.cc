#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;
	vector<string> v(n);
	vector<string> sorted_v;
	
	for (int i = 0; i < n; i++)
		cin >> v[i];

	sort(v.begin(), v.end());
	v.erase(unique(v.begin(), v.end()), v.end());
	/* unique는 중복값들을 vector의 끝으로 옮김.
	   unique의 반환값은 끝으로 옮긴 중복값들 중 첫번째의 iterator */

	for (int i = 1; i <= 50; i++) {
		for (int j = 0; j < v.size(); j++) {
			if (v[j].length() == i)
				sorted_v.push_back(v[j]);
		}
	}

	for (int i = 0; i < sorted_v.size(); i++)
		cout << sorted_v[i] << '\n';

	return 0;
}