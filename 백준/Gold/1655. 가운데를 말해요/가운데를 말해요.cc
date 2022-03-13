#include <iostream>
#include <algorithm>
#include <queue>


int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::cin >> N;
    std::priority_queue<int> small;
    std::priority_queue<int, std::vector<int>, std::greater<int>> big;
    for (int i = 0; i < N; i++) {
        int x;
        std::cin >> x;

        if (big.empty()) big.push(x);
        else if (big.top() > x) small.push(x);
        else big.push(x);

        if (big.size() <= small.size()) {
            big.push(small.top());
            small.pop();
        }
        else if (big.size() > small.size() + 2) {
            small.push(big.top());
            big.pop();
        }

        std::cout << big.top() << "\n";
    }

    return 0;
}
