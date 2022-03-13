#include <iostream>
#include <algorithm>
#include <unordered_map>

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::cin >> N;
    std::unordered_map<int, int> axis_x;
    std::unordered_map<int, int> axis_y;
    for (int i = 0; i < N; i++) {
        int x, y;
        std::cin >> x >> y;
        if (axis_x.find(x) == axis_x.end()) {
            axis_x.insert(std::make_pair(x, 1));
        }
        else {
            axis_x.at(x)++;
        }
        if (axis_y.find(y) == axis_y.end()) {
            axis_y.insert(std::make_pair(y, 1));
        }
        else {
            axis_y.at(y)++;
        }
    }
    long long cnt = 0;
    for (auto it = axis_x.begin(); it != axis_x.end(); it++) {
        long long num = it->second;
        if (num >= 2) cnt++;
    }
    for (auto it = axis_y.begin(); it != axis_y.end(); it++) {
        long long num = it->second;
        if (num >= 2) cnt++;
    }

    std::cout << cnt;

    return 0;
}