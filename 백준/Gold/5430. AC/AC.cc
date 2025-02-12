#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <deque>
#include <sstream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;
	cin >> t;
	while (t--) {
		string p;
		cin >> p;

		int n;
		cin >> n;

		deque<int> v;

		string s;
		cin >> s;
		string temp = "";
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == '[')
				continue;
			else if (s[i] == ',' || s[i] == ']') {
				if (temp == "")
					continue;

				v.push_back(stoi(temp));
				temp = "";
			}
			else
				temp += s[i];
		}

		bool front = true;
		bool error = false;
		for (int i = 0; i < p.size(); i++) {
			if (p[i] == 'R') {
				if (front == true)
					front = false;
				else
					front = true;
			}
			else if (p[i] == 'D') {
				if (v.empty() == true) {
					error = true;
					break;
				}

				if (front == true)
					v.pop_front();
				else
					v.pop_back();
			}
		}

		if (error == true) {
			cout << "error\n";
			continue;
		}
		
		cout << '[';
		if (front == true) {
			for (int i = 0; i < v.size(); i++) {
				if (i == v.size() - 1) {
					cout << v[i];
					break;
				}
				cout << v[i] << ',';
			}
		}
		else {
			for (int i = v.size() - 1; i >= 0; i--) {
				if (i == 0) {
					cout << v[i];
					break;
				}
				cout << v[i] << ',';
			}
		}

		cout << "]\n";
	}

	return 0;
}