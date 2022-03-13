#include <iostream>
#include <queue>

int main() {
    std::string str;
    std::cin >> str;
    int cnt[26];
    std::fill_n(cnt, 26, -1);
    for (int i = 0; i < str.size(); i++) {
        char c = str.at(i);
        if (cnt[c-97] == -1) cnt[c-97] = i;
    }
    for (int n : cnt) {
        std::cout << n << " ";
    }

    return 0;

}
