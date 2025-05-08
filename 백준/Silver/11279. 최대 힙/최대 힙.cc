#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, x;
	cin >> n;

	priority_queue<int> pq;
	for (int i = 0; i < n; i++) {
		cin >> x;

		if (x == 0) {
			if (pq.empty())
				cout << x << '\n';
			else {
				cout << pq.top() << '\n';
				pq.pop();
			}
		}
		else {
			pq.push(x);
		}
	}

	return 0;
}