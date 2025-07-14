#include <iostream>
#include <string>
using namespace std;

int isNumber(string s){
    try{
        return stoi(s);
    }catch(...){
        return 0;
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    for(int i = 0; i < 3; i++){
        string s;
        cin >> s;
        int temp = isNumber(s);
        
        if(temp != 0){
            n = temp + (3 - i);
        }
    }
    
    string result = to_string(n);
    if(n % 15 == 0){
        result = "FizzBuzz";
    }else if(n % 3 == 0){
        result = "Fizz";
    }else if(n % 5 == 0){
        result = "Buzz";
    }
    
    cout << result;
    return 0;
}