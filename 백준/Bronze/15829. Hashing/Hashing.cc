#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int l;
    string s;
    cin >> l >> s;
    
    long long result = 0, r = 1;
    for(int i = 0; i < l; i++){
        result += (s[i] - 'a' + 1) * r;
        result %= 1234567891;
        
        r *= 31;
        r %= 1234567891;
    }
    
    cout << result;
    return 0;
}