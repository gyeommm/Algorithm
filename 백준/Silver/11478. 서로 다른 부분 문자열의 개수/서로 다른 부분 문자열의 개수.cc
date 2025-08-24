#include <iostream>
#include <map>
#include <set>
#include <vector>
#include <string>
using namespace std;

int main()
{
    string str;
    cin >> str;

    set<string> s;
    int result = 0;
    for (int j = 1; j <= str.size(); j++) {
        for (int i = 0; i + j <= str.size(); i++)
            s.insert(str.substr(i, j));

        result += s.size();
        s.clear();
    }

    cout << result;
    return 0;
}