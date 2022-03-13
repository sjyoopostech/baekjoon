#include <iostream>
#include <algorithm>
#include <queue>

struct cmp {
    bool operator()(int a, int b) {
        return a > b;
    }
};

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::cin >> N;
    std::priority_queue<int, std::vector<int>, cmp> pq;
    for (int i = 0; i < N; i++) {
        int x;
        std::cin >> x;
        if (x == 0) {
            if (pq.empty()) std::cout << "0";
            else {
                std::cout << pq.top();
                pq.pop();
            }
            std::cout << "\n";
        }
        else {
            pq.push(x);
        }
    }

    return 0;
}
