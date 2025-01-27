#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    string s;
    cin >> s;
    
    vector<int> v(10, 0);
    for(int i = 0; i < s.length(); i++){
        int n = s[i] - '0';
        if(n == 6 || n == 9){
            n = 6;
            if(v[6] > v[9])
                n = 9;
        }
        v[n]++;
    }
    cout << *max_element(v.begin(), v.end());
    return 0;
}