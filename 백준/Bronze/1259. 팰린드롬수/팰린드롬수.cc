#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string s;
    while(true){
        cin >> s;
        if(s == "0")
            break;
        
        string reversed = s;
        reverse(reversed.begin(), reversed.end());
        if(reversed == s)
            cout << "yes\n";
        else
            cout << "no\n";
    }
    
    return 0;
}