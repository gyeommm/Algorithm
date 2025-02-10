#include <iostream>
#include <stack>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	stack<int>s;

	int k;
	int sum = 0;
	cin >> k;
	for (int i = 0; i < k; i++) {
		int n;
		cin >> n;
		if (n == 0) {
			sum -= s.top();
			s.pop();
		}
		else {
		s.push(n);
		sum += n;
		}
	}
	cout << sum << '\n';

	return 0;
}