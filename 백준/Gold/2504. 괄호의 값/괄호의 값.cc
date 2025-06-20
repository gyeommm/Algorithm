#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	string s;
	cin >> s;
	int result = 0;
	vector<pair<int, int>> temp;

	stack<int> st;
	for(int i = 0; i < s.size(); i++){
		if(s[i] == '(' || s[i] == '[')
			st.push(i);
		else if(!st.empty()){
			if((s[i] == ')' && s[st.top()] != '(') || (s[i] == ']' && s[st.top()] != '['))
				break;

			int sum;
			if(s[i] == ')')
				sum = 2;
			else if(s[i] == ']')
				sum = 3;
				
			if(st.top() == i - 1)
				temp.push_back({sum, i - 1});
			else{
				while(temp.size() > 1 && st.top() < temp[temp.size() - 2].second){
					int val = temp.back().first;
					temp.pop_back();
					temp.back().first += val;
				}

				temp.back().first *= sum;
				temp.back().second = st.top();
			}

			st.pop();
		}
		else{
			st.push(i);
			break;
		}
	}
	if(!st.empty())
		result = 0;
	else{
		while(!temp.empty()){
			result += temp.back().first;
			temp.pop_back();
		}
	}
	cout << result;

	return 0;
}