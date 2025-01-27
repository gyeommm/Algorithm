#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    string s;
    cin >> s;
    
    vector<int> v(10, 0);
    for(int i = 0; i < s.length(); i++){
        v[s[i] - '0']++;
    }
    
    v[6] = (v[6] + v[9] + 1) / 2;
    v[9] = v[6];
    cout << *max_element(v.begin(), v.end());
    return 0;
}