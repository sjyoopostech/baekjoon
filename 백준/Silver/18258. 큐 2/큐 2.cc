#include <iostream>
#include <queue>

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::cin >> N;
    std::queue<int> q;
    for (int i = 0; i < N; i++) {
        std::string s;
        std::cin >> s;

        if (s.compare("push") == 0) {
            int num;
            std::cin >> num;
            q.push(num);
        }
        else if (s.compare("pop") == 0) {
            if (q.empty()) std::cout << "-1\n";
            else {
                int num = q.front();
                std::cout << num << "\n";
                q.pop();
            }
        }
        else if (s.compare("size") == 0) {
            std::cout << q.size() << "\n";
        }
        else if (s.compare("empty") == 0) {
            if (q.empty()) std::cout << "1\n";
            else std::cout << "0\n";
        }
        else if (s.compare("front") == 0) {
            if (q.empty()) std::cout << "-1\n";
            else {
                int num = q.front();
                std::cout << num << "\n";
            }
        }
        else if (s.compare("back") == 0) {
            if (q.empty()) std::cout << "-1\n";
            else {
                int num = q.back();
                std::cout << num << "\n";
            }
        }
    }
}
