#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int arr[9], result = 0;
    for(int i = 0; i < 9; i++){
        cin >> arr[i];
    }

    for(int i = 1; i < 7; i++){
        result += arr[i] / arr[7];
        if(arr[i] % arr[7] > 0){
            result++;
        }
    }
    
    cout << result << '\n' << arr[0] / arr[8] << ' ' << arr[0] % arr[8];
    return 0;
}