#include <iostream>
#include <list>

int main() {

    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N;
    std::cin >> N;
    for (int i = 0; i < N; i++) {
        std::string str;
        std::cin >> str;
        std::list<char> l;
        auto cursor = l.end();
        for (char c : str) {
            if (c == '<') {
                if (cursor != l.begin()) cursor--;
            }
            else if (c == '>') {
                if (cursor != l.end()) cursor++;
            }
            else if (c == '-') {
                if (cursor != l.begin()) {
                    cursor--;
                    cursor = l.erase(cursor);
                }
            }
            else {
                cursor = l.insert(cursor, c);
                cursor++;
            }
        }
        for (char c : l) {
            std::cout << c;
        }
        std::cout << "\n";
    }
    return 0;
}