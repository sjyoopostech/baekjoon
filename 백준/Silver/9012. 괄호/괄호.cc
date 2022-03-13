#include <iostream>
#include <algorithm>

int main() {
    int N;
    std::cin >> N;
    for (int i = 0; i < N; i++) {
        std::string s;
        std::cin >> s;
        int open = 0;
        for (char c : s) {
            if (c == '(') open++;
            else {
                open--;
                if (open < 0) break;
            }
        }
        if (open == 0) std::cout << "YES\n";
        else std::cout << "NO\n";
    }

    return 0;
}
