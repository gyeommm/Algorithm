#include <iostream>
using namespace std;

int main(){
    string s, transform = "";
    cin >> s;
    
    if(s.back() == '_' || s[0] < 'a' || s[0] > 'z'){
        cout << "Error!";
        return 0;
    }

    for(int i = 0; i < s.length(); i++){
        if(s[i] == '_'){
            transform += s[++i] - 32;
        }
        else if(s[i] >= 'A' && s[i] <= 'Z'){
            transform += '_';
            transform += s[i] + 32;
        }
        else{
            transform += s[i];
        }
    }
    
    bool cpp = false, java = false;
    for(char c : transform){
        if(c == '_'){
            cpp = true;
        }
        else if(c >= 'A' && c <= 'Z'){
            java = true;
        }
        else if(c < 'a' || c > 'z'){
            transform = "Error!";
            break;
        }
    }
    
    if(cpp == true && java == true)
        transform = "Error!";
    cout << transform;
    return 0;
}