#include <iostream>
#include <vector>
#include <deque>
using namespace std;

int main(){
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, temp, m;
    cin >> n;
    vector<int> q_or_s(n);
    deque<int> dq;
    for(int i = 0; i < n; i++)
        cin >> q_or_s[i];

    for(int i = 0; i < n; i++){
        cin >> temp;

        if(q_or_s[i] == 0)
            dq.push_back(temp);
    }

    cin >> m;
    for(int i = 0; i < m; i++){
        cin >> temp;

        dq.push_front(temp);
        cout << dq.back() << ' ';
        dq.pop_back();
    }

    return 0;
}