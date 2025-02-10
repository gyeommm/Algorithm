#include <iostream>
#include <stack>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    stack<pair<int, int>> st;
    st.push({0, 0});
    for(int i = 1; i <= n; i++){
        int temp;
        cin >> temp;
        
        while(st.size() > 1 && st.top().second < temp){
            st.pop();
        }
        
        cout << st.top().first << ' ';
        st.push({i, temp});
    }
    
    return 0;
}