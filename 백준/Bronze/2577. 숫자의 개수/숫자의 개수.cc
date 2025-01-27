#include <iostream>
#include <string>
using namespace std;

int main(){
    int a, b, c, mul;
    cin >> a >> b >> c;
    mul = a * b * c;
    
    string s = to_string(mul);
    int arr[10] = {0,};
    for(int i = 0; i < s.length(); i++){
        arr[s[i] - '0']++;
    }
    
    for(int i = 0; i < 10; i++){
        cout << arr[i] << '\n';
    }
    
    return 0;
}