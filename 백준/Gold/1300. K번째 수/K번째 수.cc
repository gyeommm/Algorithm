#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    long long n, k;
    cin >> n >> k;

    long long mid, hi = n * n, lo = 1, count, result;
    while(lo <= hi){
        mid = (hi + lo) / 2;
        count = 0;

        for(int i = 1; i <= n; i++){
            if(mid / i == 0)
                break;
            count += min(n, mid / i);
        }

        if(count >= k){
            result = mid;
            hi = mid - 1;
        }
        else
            lo = mid + 1;
    }
    cout << result;

	return 0;
}