#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	string s;
	cin >> s;

	vector<int> dp(s.size());
	if(s[0] != '0'){
		dp[0] = 1;
		if(s[1] != '0')
			dp[1] = 1;
	}
	int temp = stoi(s.substr(0, 2));
	if(s[0] != '0' && temp >= 1 && temp <= 26)
		dp[1]++;

	for(int i = 2; i < s.size(); i++){
		if(s[i] != '0')
			dp[i] = dp[i - 1];
		temp = stoi(s.substr(i - 1, 2));
		if(s[i - 1] != '0' && temp >= 1 && temp <= 26)
			dp[i] += dp[i - 2];
		dp[i] %= 1000000;
	}
	cout << dp.back();

	return 0;
}