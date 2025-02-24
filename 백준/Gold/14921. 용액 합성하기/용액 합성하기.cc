#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; i++)
        cin >> v[i];
    
    int s = 0, e = n - 1, ans = 200000001, temp;
    while(s < e){
        temp = v[s] + v[e];
        if(abs(temp) < abs(ans))
            ans = temp;
        temp > 0 ? e-- : s++;
    }
    
    cout << ans;
    return 0;
}