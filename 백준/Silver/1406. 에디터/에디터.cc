#include <iostream>
#include <list>

int main() {

    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    std::string str;
    std::cin >> str;
    std::list<char> l;
    for (char c : str) l.push_back(c);

    int M;
    std::cin >> M;

    auto cursor = l.end();
    for (int i = 0; i < M; i++) {
        char cmd;
        std::cin >> cmd;

        if (cmd == 'L') {
            if (cursor != l.begin()) cursor--;
        }
        else if (cmd == 'D') {
            if (cursor != l.end()) cursor++;
        }
        else if (cmd == 'B') {
            if (cursor != l.begin()) {
                cursor--;
                cursor = l.erase(cursor);
            }
        }
        else {
            char c;
            std::cin >> c;
            cursor = l.insert(cursor, c);
            cursor++;
        }
    }
    for (char c : l) {
        std::cout << c;
    }
    std::cout << "\n";

    return 0;
}