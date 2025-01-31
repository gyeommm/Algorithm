#include <iostream>
#include <set>
#include <vector>
#include <string>
using namespace std;

string s;

string f(int start, int i){
    string num = s.substr(start, i - start);
    if(num[0] == '0'){
        for(int j = 1; j < num.size(); j++){
            if(num[j] != '0')
                return num.substr(j);
        }
        
        return "0";
    }
    
    return num;
}

int main(){
    int n;
    cin >> n;
    
    vector<multiset<string>> v(101);
    while(n--){
        cin >> s;
        
        int start = -1;
        for(int i = 0; i < s.size(); i++){
            if(s[i] >= '0' && s[i] <= '9'){
                if(start == -1)
                    start = i;
                continue;
            }
            
            if(start != -1){
                string num = f(start, i);
                v[num.size()].insert(num);
                start = -1;
            }
        }
        
        if(start != -1){
            string num = f(start, s.size());
            v[num.size()].insert(num);
        }
    }
    
    for(int i = 1; i <= 100; i++){
        for(string ss : v[i])
            cout << ss << '\n';
    }
    return 0;
}