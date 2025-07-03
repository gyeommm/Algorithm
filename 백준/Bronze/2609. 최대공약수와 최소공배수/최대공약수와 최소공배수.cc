#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int a, b, lcm;
    cin >> a >> b;
    lcm = a * b;
    
    while(b != 0){
        int temp = a;
        a = b;
        b = temp % b;
    }
    
    cout << a << '\n' << lcm / a; 
}