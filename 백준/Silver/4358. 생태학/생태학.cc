#include <iostream>
#include <algorithm>
#include <cmath>

class Trie {
public:
    int number;
    Trie* child[128];

    Trie() {
       this->number = 0;
       for (int i = 0; i < 128; i++) this->child[i] = NULL;
    }
};

void dfs(Trie* now, int total, std::string& s) {
    if (now->number > 0) {
        double d = (double)now->number / total;
        std::cout << s << " " << d*100 << "\n";
    }
    for (int i = 0; i < 128; i++) {
        if (now->child[i] != NULL) {
            s.push_back(i);
            dfs(now->child[i], total, s);
            s.pop_back();
        }
    }
}

int main() {
    std::cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);
    std::cout << std::fixed;
    std::cout.precision(4);

    Trie* head = new Trie();
    int total = 0;
    std::string s;


    while (getline(std::cin, s)) {
        if (s.empty()) break;
        Trie* now = head;
        for (char c : s) {
            if (now->child[c] == NULL) {
                now->child[c] = new Trie();
            }
            now = now->child[c];
        }
        now->number++;
        total++;
    }
    s = "";
    dfs(head, total, s);

    return 0;
}
