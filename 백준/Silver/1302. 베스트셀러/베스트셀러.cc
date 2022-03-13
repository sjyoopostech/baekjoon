#include <iostream>
#include <algorithm>
#include <unordered_map>

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N, M;
    std::cin >> N;

    std::unordered_map<std::string, int> map;
    std::string max_str = "";
    int max_num = 0;

    for (int i = 0; i < N; i++) {
        std::string str;
        std::cin >> str;
        if (map.find(str) == map.end()) map.insert(make_pair(str, 1));
        else map.at(str)++;

        if (map.at(str) > max_num) {
            max_str = str;
            max_num = map.at(str);
        }
        else if (map.at(str) == max_num && str < max_str) {
            max_str = str;
            max_num = map.at(str);
        }
    }
    std::cout << max_str;

    return 0;
}