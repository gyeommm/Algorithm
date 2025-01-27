#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int arr[13];
	for (int i = 0; i < 10; i++)
		arr[i] = 0;
	cin >> arr[10] >> arr[11] >> arr[12];

	string result = to_string(arr[10] * arr[11] * arr[12]);

	int n;
	for (int i = 0; i < result.length(); i++) {
		n = result[i] - '0';
		arr[n]++;
	}

	for (int i = 0; i < 10; i++)
		cout << arr[i] << '\n';

	return 0;
}