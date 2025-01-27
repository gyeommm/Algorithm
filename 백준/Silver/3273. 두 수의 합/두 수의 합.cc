#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, x;
	cin >> n;

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end());

	cin >> x;
	int left = 0, right = n - 1, count = 0, sum;
	while (left < right) {
		sum = v[left] + v[right];

		if (sum > x)
			right--;
		else if (sum < x)
			left++;
		else {
			left++; right--;
			count++;
		}
	}

	cout << count << '\n';
	return 0;
}