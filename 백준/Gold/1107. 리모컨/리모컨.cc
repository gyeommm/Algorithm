#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

    int n, m, temp, result = 500000;
    cin >> n >> m;
    vector<bool> b(10, true);
    for(int i = 0; i < m; i++){
        cin >> temp;
        b[temp] = false;
    }

    for(int i = 0; i <= 1000000; i++){
        string s = to_string(i);
        bool check = true;
        for(int j = 0; j < s.size(); j++){
            if(b[s[j] - '0'] == false){
                check = false;
                break;
            }
        }
        
        if(check)
            result = min(result, int(s.size()) + abs(n - i));
    }

    cout << min(result, abs(n - 100));

	return 0;
}