#include <iostream>
#include <algorithm>
#include <vector>

int main() {
    int N;
    std::cin >> N;
    std::vector<int> v;
    for (int i = 0; i < N; i++) {
        int n;
        std::cin >> n;
        v.push_back(n);
    }
    std::sort(v.begin(), v.end());
    for (int x : v) {
        std::cout << x << "\n";
    }
    return 0;
}
