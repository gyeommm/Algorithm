#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string s, result = "mixed";
    for(int i = 0; i < 8; i++){
        char c;
        cin >> c;
        s += c;
    }
    
    if(s == "12345678")
        result = "ascending";
    else if(s == "87654321")
        result = "descending";
    cout << result;
    
    return 0;
}