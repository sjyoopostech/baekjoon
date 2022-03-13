#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

int main() {
    while (true) {
        char clist[105];
        std::cin.getline(clist, 105);
        std::string s = std::string(clist);
        if (s.compare(".") == 0) break;

        std::stack<bool> v;
        bool isgood = true;
        for (char c : s) {
            if (c == '[') v.push(true);
            else if (c == '(') v.push(false);
            else if (c == ']') {
                if (v.empty()) {
                    isgood = false;
                    break;
                }
                else if (v.top() != true) {
                    isgood = false;
                    break;
                }
                else v.pop();
            }
            else if (c == ')') {
                if (v.empty()) {
                    isgood = false;
                    break;
                }
                else if (v.top() != false) {
                    isgood = false;
                    break;
                }
                else v.pop();
            }
        }
        if (isgood && v.empty()) std::cout << "yes\n";
        else std::cout << "no\n";
    }

    return 0;
}
