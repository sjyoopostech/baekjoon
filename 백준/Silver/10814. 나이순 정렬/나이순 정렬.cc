#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>

bool Compare(std::tuple<int,int,std::string> a, std::tuple<int,int,std::string> b) {
    if (std::get<0>(a) != std::get<0>(b)) return std::get<0>(a) < std::get<0>(b);
    return std::get<1>(a) < std::get<1>(b);
}

int main() {
    int N;
    std::cin >> N;
    std::vector<std::tuple<int,int,std::string>> v;
    for (int i = 0; i < N; i++) {
        int n;
        std::string s;
        std::cin >> n;
        std::cin >> s;
        v.push_back({n,i,s});
    }
    std::sort(v.begin(), v.end(), Compare);
    for (std::tuple<int,int,std::string> p : v) {
        std::cout << std::get<0>(p) << " " << std::get<2>(p) << "\n";
    }
    return 0;
}
