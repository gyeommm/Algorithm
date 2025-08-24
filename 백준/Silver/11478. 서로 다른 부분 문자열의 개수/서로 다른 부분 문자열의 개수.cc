#include <iostream>
#include <string>
#include <unordered_set>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

    string s;
    cin >> s;

    unordered_set<string> us;
    int result = 0;
    for (int i = 1; i <= s.size(); i++) {
        for (int j = 0; j + i <= s.size(); j++)
            us.insert(s.substr(j, i));
        
        result += us.size();
        us.clear();
    }

    cout << result;
    return 0;
}