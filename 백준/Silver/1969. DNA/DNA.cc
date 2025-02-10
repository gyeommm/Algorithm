#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

bool cmp(pair<char, int> a, pair<char, int> b){
    return a.second < b.second;
}

int main(){
    int n, m, hd = 0;
    string dna = "";
    cin >> n >> m;
    
    vector<string> v(n);
    for(int i = 0; i < n; i++){
        cin >> v[i];
    }
    
    map<char, int> mm;
    for(int i = 0; i < m; i++){
        mm.clear();
        for(int j = 0; j < n; j++){
            mm[v[j][i]]++;
        }
        
        auto temp = max_element(mm.begin(), mm.end(), cmp);
        dna += temp->first;
        hd += n - temp->second;
    }
    
    cout << dna << '\n' << hd;
    
    return 0;
}