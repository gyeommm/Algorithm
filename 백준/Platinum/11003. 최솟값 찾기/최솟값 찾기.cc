#include <iostream>
#include <queue>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n, l;
    cin >> n >> l;
    
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        
        pq.push({a, i});
        while(true){
            pair<int, int> temp = pq.top();
            
            if(temp.second > i - l){
                cout << temp.first << " ";
                break;
            }
            pq.pop();
        }
    }
    
    return 0;
}