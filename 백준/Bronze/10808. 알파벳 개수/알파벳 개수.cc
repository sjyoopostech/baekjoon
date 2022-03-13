#include <iostream>
#include <queue>

int main() {
    std::string str;
    std::cin >> str;
    int cnt[26];
    std::fill_n(cnt, 26, 0);
    for (char c : str) {
        cnt[c-97]++;
    }
    for (int n : cnt) {
        std::cout << n << " ";
    }

    return 0;

}
