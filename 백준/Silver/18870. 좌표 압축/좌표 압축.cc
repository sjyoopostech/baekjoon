#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>

bool Compare1 (std::tuple<int,int,int> a, std::tuple<int,int,int> b) {
    return std::get<1>(a) < std::get<1>(b);
}

bool Compare2 (std::tuple<int,int,int> a, std::tuple<int,int,int> b) {
    return std::get<0>(a) < std::get<0>(b);
}

int main() {
    int N;
    std::cin >> N;
    std::vector<std::tuple<int,int,int>> v;
    for (int i = 0; i < N; i++) {
        int n;
        std::cin >> n;
        v.push_back({i, n, 0});
    }
    std::sort(v.begin(), v.end(), Compare1);
    for (int i = 1; i < v.size(); i++) {
        if (std::get<1>(v.at(i)) > std::get<1>(v.at(i-1))) {
            std::get<2>(v.at(i)) = std::get<2>(v.at(i-1)) + 1;
        }
        else {
            std::get<2>(v.at(i)) = std::get<2>(v.at(i-1));
        }
    }
    std::sort(v.begin(), v.end(), Compare2);
    for (std::tuple<int,int,int> x : v) {
        std::cout << std::get<2>(x) << " ";
    }

    return 0;
}
