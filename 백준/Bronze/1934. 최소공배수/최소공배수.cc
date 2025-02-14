#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
#include <string>
#include <stack>
using namespace std;

int gcd(int a, int b) {
	int temp;

	while(b != 0) {
		temp = a % b;
		a = b;
		b = temp;
	}

	return a;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t, a, b, ans;
	cin >> t;
	while (t--) {
		cin >> a >> b;
		if (a < b)
			swap(a, b);
		ans = gcd(a, b);

		ans = a * (b / ans);
		cout << ans << '\n';
	}

	return 0;
}