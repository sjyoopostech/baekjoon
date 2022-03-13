#include <iostream>
#include <algorithm>
#include <cmath>

class Trie {
public:
    int number;
    Trie* child[10];

    Trie() {
       this->number = 0;
       for (int i = 0; i < 10; i++) this->child[i] = NULL;
    }
};

int main() {
    std::cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int T;
    std::cin >> T;
    for (int t = 0; t < T; t++) {
        int N;
        std::cin >> N;

        Trie* head = new Trie();
        bool istrue = true;
        for (int i = 0; i < N; i++) {
            std::string s;
            std::cin >> s;

            if(!istrue) continue;
            Trie* now = head;
            for (char c : s) {
                if (now->child[c - '0'] == NULL) {
                    now->child[c - '0'] = new Trie();
                }
                now = now->child[c - '0'];
                if (now->number > 0) {
                    istrue = false;
                    break;
                }
            }
            now->number++;
            for (int i = 0; i < 10; i++) {
                if (now->child[i] != NULL) {
                    istrue = false;
                    break;
                }
            }
        }
        if (istrue) std::cout << "YES\n";
        else std::cout << "NO\n";
    }

    return 0;
}
