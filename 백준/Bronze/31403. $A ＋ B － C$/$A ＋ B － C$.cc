#include <iostream>
#include <string>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int s[3];
    cin >> s[0] >> s[1] >> s[2];
    cout << s[0] + s[1] - s[2] << '\n' << stoi(to_string(s[0]) + to_string(s[1])) - s[2];
    
    return 0;
}