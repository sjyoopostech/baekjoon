#include <iostream>
#include <algorithm>
#include <unordered_map>

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

    int N, M;
    std::cin >> N >> M;

    std::unordered_map<std::string, std::string> map;
    for (int i = 0; i < N; i++) {
        std::string site;
        std::string password;
        std::cin >> site;
        std::cin >> password;
        map.insert(make_pair(site, password));
    }
    for (int i = 0; i < M; i++) {
        std::string site;
        std::cin >> site;
        std::cout << map.at(site) << '\n';
    }

    return 0;
}