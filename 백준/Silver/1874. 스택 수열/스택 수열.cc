#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

    int N, n, num = 1;
    string ans;
    vector<int> v;
    stack<int> sub;

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> n; v.push_back(n);
    }

    for (int i = 0; i < N; i++) {
        while (1) {
            if (!sub.empty() && v[i] == sub.top()) {
                ans += "-\n";
                sub.pop();
                break;
            }
            else {
                if (num > N) {
                    cout << "NO" << endl;
                    return 0;
                }
                sub.push(num);
                ans += "+\n";
                ++num;
            }
        }
    }
    cout << ans << endl;
    return 0;
}