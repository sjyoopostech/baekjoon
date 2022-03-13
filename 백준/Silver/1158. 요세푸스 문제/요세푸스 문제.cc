#include <iostream>
#include <list>

int main() {

    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N, K;
    std::cin >> N >> K;
    std::list<int> l;
    for (int i = 1; i <= N; i++) {
        l.push_back(i);
    }

    std::cout << "<";
    auto it = l.end();
    it--;
    while (!l.empty()) {
        for (int i = 0; i < K; i++) {
            it++;
            if (it == l.end()) it = l.begin();
        }
        std::cout << *it;
        it = l.erase(it);
        if (!l.empty()) std::cout << ", ";
        else break;


        if (it == l.begin()) {
            it = l.end();
        }
        it--;
    }
    std::cout << ">";

    return 0;
}