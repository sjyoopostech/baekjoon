#include <iostream>
#include <algorithm>
#include <vector>

long long HashFunction(std::string str) {
    int size = str.size();
    long long r = 31;
    long long M = 1234567891;
    long long now = 0;
    for (int i = size-1; i >= 0; i--) {
        now += str.at(i) - 96;
        if (i > 0) now *= r;
        now %= M;
    }
    return now;
}

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::string s;
    std::cin >> N >> s;
    std::cout << HashFunction(s);
    return 0;
}
