#include <iostream>
#include <algorithm>

class Trie {
public:
    bool isexist;
    Trie* child[26];

    Trie() {
       this->isexist = false;
       for (int i = 0; i < 26; i++) this->child[i] = NULL;
    }
};

int main() {

    int N, M;
    std::cin >> N >> M;

    Trie* head = new Trie();
    for (int i = 0; i < N; i++) {
        std::string s;
        std::cin >> s;
        Trie* now = head;
        for (char c : s) {
            if (now->child[c - 'a'] == NULL) {
                now->child[c - 'a'] = new Trie();
            }
            now = now->child[c - 'a'];
        }
        now->isexist = true;
    }
    int sum = 0;
    for (int i = 0; i < M; i++) {
        std::string s;
        std::cin >> s;
        Trie* now = head;
        bool exist = true;
        for (char c : s) {
            if (now->child[c - 'a'] == NULL) {
                exist = false;
                break;
            }
            now = now->child[c - 'a'];
        }
        if (exist && now->isexist) sum++;
    }
    std::cout << sum;


    return 0;
}
